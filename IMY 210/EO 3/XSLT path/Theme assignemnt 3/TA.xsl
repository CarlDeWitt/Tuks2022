<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html"/>
	<xsl:template match="/">
		<b>
Available Books	</b>
		<br/>
		<xsl:apply-templates select="up"/>
		<br/>
		<br/>
		Total books available: 
		<xsl:value-of select="count(//book[not (@status = 'out')])"/>
		<br/>
		Total books taken out: 
		<xsl:value-of select="count(up/library/book[@status = 'out'])"/>
	</xsl:template>
	<xsl:template match="book">
		Book 
		<xsl:value-of select="@isbn[not(@status = 'out')]"/>
		can be found
 in merensky
		<xsl:value-of select="library/@name"/>
		<br/>
	</xsl:template>
</xsl:stylesheet>
