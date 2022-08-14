<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:output method="html"/>

    <xsl:template match="/">
    <html>
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <body>   
            <div class="contain">
                <xsl:apply-templates select="schedule/event" />
            </div>         
        </body>
    </html>
    </xsl:template>

    <xsl:template match="event">
        <div class="all">
            <h1>
                <xsl:value-of select="./title"/>
            </h1>
            <h2>
                <xsl:value-of select="./type"/>
            </h2>
            <div>
                <xsl:value-of select="./date/day"/>
                <xsl:value-of select="./date/month"/>
                <xsl:value-of select="./date/startingTime"/>
                <xsl:value-of select="./date/endingTime"/>
            </div>
            <div>
                <xsl:for-each select="./guests/guest">
                    <xsl:value-of select="./name"></xsl:value-of>
                    <xsl:value-of select="./email"></xsl:value-of>
                </xsl:for-each>
            </div>
            <div>
                <xsl:value-of select="./venue"/>
                <xsl:value-of select="./description"/>
            </div>
        </div>
    </xsl:template>
</xsl:stylesheet>