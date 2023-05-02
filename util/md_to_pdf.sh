#!/bin/bash
TESTES_HOME=~/Documents/unb/TESTES/

if [ $# -ne 3 ]; then
  echo "
Use md_to_pdf.sh [SOURCE FILENAME] [DESTINATION PREFIX] [DOCUMENT TITLE]
Example: md_to_pdf.sh exercicio1.md aula1exer1.pdf \"Aula 1 - Exercício 1\""
  exit 1
fi

filename=$1
destname=$2
title=$3
filename_pattern="_nicolas.pdf"
yaml_config="---
title: $title
author: \"Nicolas Chagas Souza - 200042327\"
date: $(date +"%d/%m/%Y")
linestretch: 1.5
output: pdf_document
font: Arial
fontsize: 12pt
papersize: a4
number-sections: false
lang: pt-BR
include-in-header:<style> h1,h2,h3,h4 {  background-color: red;}</style>

---
$header
<div style=\"text-align: justify\">
"

echo "$yaml_config$(cat "$filename")
</div>" >temp.md

# Converts underlines from markdown to latex
sed -i 's/<u>/\\underline\{/g' temp.md
sed -i 's/<\/u>/\}/g' temp.md

# Converts linebreaks from markdown to latex
sed -i 's/<br\/>/\\newline/g' temp.md

pandoc temp.md -o "$TESTES_HOME/entregas/$destname$filename_pattern" --include-in-header "$TESTES_HOME/util/tex-templates/header.tex"

rm temp.md
