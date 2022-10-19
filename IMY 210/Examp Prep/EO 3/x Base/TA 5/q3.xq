
for $cds in doc("cd.xml")/CATALOG return <HTML><TOTAL>{count(for $cnt in $cds/CD return $cnt)}</TOTAL>,

{for $cds in doc("cd.xml")/CATALOG return 
<ABOVE> 
<COUNT>{count(for $count in $cds/CD where $count/PRICE > 9 return $count)} </COUNT>

{ for $ti1 in $cds/CD where $ti1/PRICE > 9 order by $ti1/COUNTRY return $ti1/TITLE}
 </ABOVE>},
 
 {for $cds in doc("cd.xml")/CATALOG return <BELOW> <COUNT>{count(for $count in $cds/CD where $count/PRICE <= 9 return $count)} </COUNT>
{ for $ti1 in $cds/CD where $ti1/PRICE <= 9 order by $ti1/COUNTRY return $ti1/TITLE}
 </BELOW>}</HTML>

  for $var2 in doc("query-xml-two.xml")/modules/module order by $var2/name return $var2/name},