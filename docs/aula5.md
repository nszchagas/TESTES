<link rel="stylesheet" href="/style.css"/>

# Test-driven Development

## Chapter 1

TDD is a simple procedure of writing tests **before the actual implementation**. It's an inversion of a traditional approach where testing is performed after the code is written.

**Red-green-refactor**: Test-driven development is a process that relies on the repetition of a very short development cycle. It is based on the test-first concept of extreme programming that encourages simple design with a high level of confidence. While writing tests we're in the red state, when the implementation of a test is finished, all tests should pass and then we'll be in the green state.

> When a test fails, the programmer should spend little time trying to fix it. So, if the change can't be done in a matter of minutes it's better to revert the changes and start over.

After all tests are passing, it's time to refactor the code, if the refactor breaks an existing functionality the tests will show and the changes must be reverted.

### Speed is the key

The first implementation should not be focused on perfection, the idea is to keep switching between tests and implementation as fast as a game of ping-pong.

> The time between changing from tests to implementation should be measured in minutes or seconds.

TDD is a solution to approach the design in a different way, in such the programmer is forced to think about the implementation and about what the code needs to do before implementation. The main objective of TDD is testable code design with tests as a very useful side product.

> Tests that are defined by an already existing application are biased. They have a tendency to confirm what code does, and not to test whether client's expectations are met, or that the code is behaving as expected.

### Mocking

In order for tests to run fast and provide constant feedback, code needs to be organized in such a way that the methods, functions, and classes **can be easily replaced with mocks and stubs**. With or without mocks, the code should be written in a way that we
can easily replace one dependency with another.

## Chapter 3

The following code extracts use this structure:

```java title="TicTacToe.java" linenums="1"
--8<--
tdd-ch3/src/main/java/com/packtpublishing/tddjava/ch03tictactoe/TicTacToe.java:setup
--8<--
}
```

### Requirement 1

A piece can be placed on any empty space of a 3×3 board.

#### REQ1 - Red State

Tests for this requirement:

```java title="TicTacToeSpec.java" linenums="1"
--8<--
tdd-ch3/src/test/java/com/packtpublishing/tddjava/ch03tictactoe/TicTacToeSpec.java:req1
--8<--
```

#### REQ1 - Green State

Implementation passing all tests and after refactoring.

```java title="TicTacToe.java" linenums="1"
--8<--
tdd-ch3/src/main/java/com/packtpublishing/tddjava/ch03tictactoe/TicTacToe.java:req1
--8<--
```

### Requirement 2

There should be a way to find out which player should play next.

#### REQ2 - Red State

Tests for this requirement:

```java title="TicTacToeSpec.java" linenums="1"
--8<--
tdd-ch3/src/test/java/com/packtpublishing/tddjava/ch03tictactoe/TicTacToeSpec.java:req2
--8<--
```

#### REQ2 - Green State

Implementation passing all tests and after refactoring.

```java title="TicTacToe.java" linenums="1"
--8<--
tdd-ch3/src/main/java/com/packtpublishing/tddjava/ch03tictactoe/TicTacToe.java:req2
--8<--
```

### Requirement 3

A player wins by being the first to connect a line of friendly pieces from one side or corner of the board to the other.

#### REQ3 - Red State

Tests for this requirement:

```java title="TicTacToeSpec.java" linenums="1"
--8<--
tdd-ch3/src/test/java/com/packtpublishing/tddjava/ch03tictactoe/TicTacToeSpec.java:req3
--8<--
```

#### REQ3 - Green State

Implementation passing all tests and after refactoring.

```java title="TicTacToe.java" linenums="1"
--8<--
tdd-ch3/src/main/java/com/packtpublishing/tddjava/ch03tictactoe/TicTacToe.java:req3
--8<--
```

### Requirement 4

The result is a draw when all the boxes are filled.

#### REQ4 - Red State

Tests for this requirement:

```java title="TicTacToeSpec.java" linenums="1"
--8<--
tdd-ch3/src/test/java/com/packtpublishing/tddjava/ch03tictactoe/TicTacToeSpec.java:req4
--8<--
```

#### REQ4 - Green State

Implementation passing all tests and after refactoring.

```java title="TicTacToe.java" linenums="1"
--8<--
tdd-ch3/src/main/java/com/packtpublishing/tddjava/ch03tictactoe/TicTacToe.java:req3
--8<--
```

### Jacoco Report

<center>

![](./assets/aula5/2457.png)

<fig>Results after running `gradle test jacocoReport`</fig>
</center>
