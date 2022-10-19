<list>{
for $cds in doc("cd.xml")/CATALOG/CD 
where $cds/YEAR <= 1987
return <li>{data($cds/TITLE)} by {data($cds/ARTIST)} - {data($cds/COMPANY)},{data($cds/COUNTRY)}</li>}</list>