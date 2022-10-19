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
            <p class="head1">
                <xsl:value-of select="./title"/>
            </p>
            <p class="head2">
                <xsl:value-of select="./type"/>
            </p>
            <div class="bkr">
                <div class="str">
                    <hr/>
                    <p class="imp">Date:</p>
                    <br/>
                    <xsl:value-of select="./date/day"/> &#160;
                    <xsl:value-of select="./date/month"/> &#160;
                    <xsl:value-of select="./date/startingTime"/> &#160;
                    <xsl:value-of select="./date/endingTime"/>
                    <hr/>
                </div>
                <div class="end">
                    <p class="imp">Guest:</p>
                    <xsl:for-each select="./guests/guest">
                        <div class="gst">
                           Name: <xsl:value-of select="./name"></xsl:value-of> <br/>
                           <xsl:value-of select="./email"></xsl:value-of>
                        </div>
                    </xsl:for-each>
                </div>
            </div>
            <div class="rest">
                Location: <xsl:value-of select="./venue"/><br/><br/>
                Desc: <xsl:value-of select="./description"/>
            </div>
            
        </div>
    </xsl:template>
</xsl:stylesheet>