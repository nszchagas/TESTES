#!/bin/bash

cd "$HOME"/Documents/unb/TESTES || exit 1
pipenv run mkdocs serve
