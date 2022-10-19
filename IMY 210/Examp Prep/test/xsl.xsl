<?xml version="1.0"?>
<xsl:stylesheet version="1.0"	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html"/>
	<xsl:template match="/">	
		<!--<b><xsl:value-of select="contact/name/@unit"/></b>
		<b><xsl:value-of select="contact/age"/></b>
		<b><xsl:value-of select="contact/location"/></b>
		<xsl:attribute name="href">
			<xsl:value-of select="contact/name"></xsl:value-of>
		</xsl:attribute>-->

		test position() = contact/name.last();
		<xsl:for-each select="contact/name">
		<xsl:value-of select="."/>,
	</xsl:for-each>
	</xsl:template>
</xsl:stylesheet>
<!--<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="xsl.xsl"?>
<contact>
    <name unit="male">John</name>
    <age>16</age>
    <location>here</location>
    <sport></sport>
</contac-->