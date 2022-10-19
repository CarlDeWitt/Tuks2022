
for $var in doc("query-xml-one.xml")/students/student order by $var/@id return <student>{$var/@id}{

for $var1 in $var/module order by $var1/@department where $var1/@department = "CS" return <module> {$var1/@department},

{

for $var1 in $var/module order by $var1/@department where $var1/@department = "CS" return <module> {$var1/@department},

{

for $var1 in $var/module order by $var1/@department where $var1/@department = "CS" return <module> {$var1/@department},


</module>},
</student>


