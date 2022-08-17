<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <link rel="stylesheet" href="/style.css">
</head>
<body>
<div>
<#list codeList as code>
    <span id="load_date">${code.date}</span>
    <pre id="code_snippet">${code.code}</pre>
</#list>
</div>
</body>
</html>