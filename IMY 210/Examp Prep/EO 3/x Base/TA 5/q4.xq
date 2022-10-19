<body>
<cheap>{
  <count>{
 count(for $cds in doc("cd.xml")/CATALOG/CD where $cds/PRICE < 9 return $cds/TITLE)
}</count>,
for $cds in doc("cd.xml")/CATALOG/CD where $cds/PRICE < 9 order by $cds/PRICE return <li> {data($cds/TITLE)} </li>
}</cheap>
<exspensive>{
  <count>{
 count(for $cds in doc("cd.xml")/CATALOG/CD where $cds/PRICE > 9 return $cds/TITLE)
}</count>,
for $cds in doc("cd.xml")/CATALOG/CD where $cds/PRICE > 9 order by $cds/PRICE return <li> {data($cds/TITLE)} </li>
}</exspensive>
</body>