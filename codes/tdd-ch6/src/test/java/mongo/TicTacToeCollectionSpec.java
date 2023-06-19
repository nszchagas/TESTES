package mongo;

import com.mongodb.MongoException;
import main.Piece;
import org.jongo.MongoCollection;
import org.junit.Before;
import org.junit.Test;

import java.net.UnknownHostException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

//--8<-- [start:req1]
public class TicTacToeCollectionSpec {
    TicTacToeCollection collection;

    MongoCollection mongoCollection;
    private final Piece x = Piece.X;
    private final Piece o = Piece.O;

    private final TicTacToeBean bean = new TicTacToeBean(1, 0, 2, x);

    @Before
    public void before() {
        try {
            collection = spy(new TicTacToeCollection());
            mongoCollection = mock(MongoCollection.class);

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void whenInstantiatedThenMongoHasDbNameTicTacToe() {
        assertEquals("tic-tac-toe", collection.getMongoCollection().getDBCollection().getDB().getName());
    }

    @Test
    public void whenInstantiatedThenMongoDbHasCollectionNameGame() {
        assertEquals("game", collection.getMongoCollection().getName());
    }

    @Test
    public void whenSaveMoveThenInvokeMongoCollectionSave() {
        TicTacToeBean bean = new TicTacToeBean(1, 0, 2, x);
        doReturn(mongoCollection).when(collection).getMongoCollection();
        collection.saveMove(bean);
        verify(mongoCollection, times(1)).save(bean);
    }

    @Test
    public void assertSaveMoveReturnsTrueOnSuccess() {
        doReturn(mongoCollection).when(collection).getMongoCollection();
        assertTrue(collection.saveMove(bean));
    }

    @Test
    public void assertSaveMoveReturnsFalseOnException() {
        doThrow(new MongoException("Generic exception"))
                .when(mongoCollection)
                .save(any(TicTacToeBean.class));
        assertFalse(collection.saveMove(bean));
    }

    @Test
    public void testDropDatabase() {
        doReturn(mongoCollection).when(collection).getMongoCollection();
        collection.drop();
        verify(mongoCollection).drop();
    }

    @Test
    public void assertTrueOnDrop() {
        doReturn(mongoCollection).when(collection).getMongoCollection();
        assertTrue(collection.drop());
    }

    @Test
    public void assertFalseOnExceptionDuringDrop() {
        doThrow(new MongoException("Generic exception")).when(mongoCollection).drop();
        doReturn(mongoCollection).when(collection).getMongoCollection();
        assertFalse(collection.drop());
    }

    //--8<-- [end:req1]
}
