<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:output method="html"/>

<xsl:template match="/">
  <html>
    <body style="background-image:url('background.jpg');display: flex;flex-direction: column;justify-content: center;align-items: center;color:white">
        <img src="diablo3-logo.png"/>
        <div style="width:90%;background-color:rgba(102, 10, 21,0.5);padding:20px;border-radius:20px;color:#fbe6c0;display: flex;
        flex-direction: column;justify-content: center;align-items: center;font-size: 25px;">
            <div style="display: flex;justify-content: center;align-items: center;">
            <img style="margin-right: 100px;" src="face.png"/>
            <p style="font-size: 45px;">
                <xsl:value-of select="character/class/basic/name"/>
            </p>
            </div>
            <p>
                Last updated on <xsl:value-of select="character/class/basic/update"/>
                by <xsl:value-of select="character/class/basic/creator"/>
                <br/>
            </p>
            <p>
                URL:
                <a>
                    <xsl:attribute name="href">
                        <xsl:value-of select="character/@source"/>
                    </xsl:attribute>
                    <xsl:value-of select="character/@source"/>
                </a>
                
            </p>
            <p style="color:#ffae43">
                Tags:
                <!-- <xsl:template match="character/class/basic/tags[tag/@status]"/> -->
                <xsl:for-each select="character/class/basic/tags/tag">
                    <xsl:if test="not(@status) != true">
                        <xsl:value-of select="."/>
                        &#160;
                    </xsl:if>
                
                </xsl:for-each>
            </p>
        
        
        <p>
            <b style="font-size:20px;">
                Level required for this build:
            </b>
            <xsl:for-each select="character/class/skills/skill/requirements/level">
                <xsl:sort data-type="number" select="." order="descending"/>
                <xsl:if test="position() =1"><xsl:value-of select="."></xsl:value-of></xsl:if>        
            </xsl:for-each>
            <b style="font-size:20px;">
            Average item level:
            </b>
                <xsl:value-of select="ceiling(sum(//items/item/requirements/level) div count(//items/item/requirements/level)) "/>
                
        </p>
        </div>

        <h2 style="font-size:45px;color:#fbe6c0;">
            Pargon Priorities
        </h2>
        <div style="display:flex;justify-content:center;background-color:rgba(102, 10, 21,0.5);padding:20px;border-radius:20px;color:#A79386;font-size:18px;">
            <div id="core" style="margin:0 20px;font-size: 45px;color:#ffae43;">
                <xsl:value-of select="character/class/paragon[1]/@set"/>
                <div class="inside" style="color:#A79386;font-size:18px;margin-top:10px;">
                    <xsl:for-each select="character/class/paragon[1]/priority">
                        <xsl:sort data-type="number" order="ascending" select="./@weight"/>
                        <xsl:value-of select="./@weight"/>&#160;<xsl:value-of select="."/>
                        <br/>
                    </xsl:for-each>
                </div>
            </div>
            <div id="movement" style="margin:0 20px;font-size: 45px;color:#ffae43;">
                <xsl:value-of select="character/class/paragon[2]/@set"/>
                <div class="inside" style="color:#A79386;font-size:18px;margin-top:10px;">
                    <xsl:for-each select="character/class/paragon[2]/priority">
                        <xsl:sort data-type="number" order="ascending" select="./@weight"/>
                        <xsl:value-of select="./@weight"/>&#160;<xsl:value-of select="."/>
                        <br/>
                    </xsl:for-each>
                </div>
            </div>
            <div id="defense" style="margin:0 20px;font-size: 45px;color:#ffae43;">
                <xsl:value-of select="character/class/paragon[3]/@set"/>
                <div class="inside" style="color:#A79386;font-size:18px;margin-top:10px;">
                    <xsl:for-each select="character/class/paragon[3]/priority">
                        <xsl:sort data-type="number" order="ascending" select="./@weight"/>
                        <xsl:value-of select="./@weight"/>&#160;<xsl:value-of select="."/>
                        <br/>
                    </xsl:for-each>
                </div>
            </div>
            <div id="util" style="margin:0 20px;font-size: 45px;color:#ffae43;">
                <xsl:value-of select="character/class/paragon[4]/@set"/>
                <div class="inside" style="color:#A79386;font-size:18px;margin-top:10px;">
                    <xsl:for-each select="character/class/paragon[4]/priority">
                        <xsl:sort data-type="number" order="ascending" select="./@weight"/>
                        <xsl:value-of select="./@weight"/>&#160;<xsl:value-of select="."/>
                        <br/>
                    </xsl:for-each>
                </div>
            </div>            
        </div>

        <h2 style="font-size:45px;color:#fbe6c0;">
            Skill
        </h2>
        
        <div style="display:flex;width:90%;flex-wrap: wrap;justify-content: space-around;background-color:rgba(102, 10, 21,0.5);padding:20px;border-radius:20px;color:#A79386;font-size:18px;">
            <div style="color:#daad7d;font-size:30px;">
                Active Skills
            </div>
            <div style="display:flex;width:100%;flex-wrap: wrap;justify-content: space-around;">
                <xsl:apply-templates select="character/class/skills/skill[@type='active']">
                    <!-- <xsl:sort data-type="number" order="ascending" select="requirements/level"/>     -->
                </xsl:apply-templates>
            </div>
        </div>

        <div style="display:flex;width:90%;flex-wrap: wrap;justify-content: space-around;background-color:rgba(102, 10, 21,0.5);padding:20px;border-radius:20px;color:#A79386;font-size:18px;margin-top:40px;">
            <div style="color:#daad7d;font-size:30px;">
            Passive Skills
            </div>
            <div style="display:flex;width:100%;flex-wrap: wrap;justify-content: space-around;">
            <xsl:apply-templates select="character/class/skills/skill[@type='passive']">
                <xsl:sort data-type="number" order="descending" select="requirements/level"/>    
            </xsl:apply-templates>
            </div>
        </div>
        <h2 style="font-size:45px;color:#fbe6c0;">
            Gear
        </h2>

        <div style="display:flex;width:90%;flex-wrap: wrap;justify-content: space-around;background-color:rgba(102, 10, 21,0.5);padding:20px;border-radius:20px;color:#A79386;font-size:18px;">
            <xsl:apply-templates select="character/class/items"/>
        </div>

        <h2 style="font-size:45px;color:#fbe6c0;">
            Kanai's Cube
            
        </h2>
        <div style="display:flex;width:90%;flex-wrap: wrap;justify-content: space-around;background-color:rgba(102, 10, 21,0.5);padding:20px;border-radius:20px;color:#A79386;font-size:18px;">
            <xsl:apply-templates select="character/class/cubes">
                    <!-- <xsl:sort data-type="string" order="ascending" select="items/name"/> -->
                    <xsl:sort select="item/name"/>
            </xsl:apply-templates>
        </div>

    </body>
  </html>
</xsl:template>

<!-- SKILLS -->

<xsl:template match="skill[@type = 'active']"> 
    <div style="width:35ch;margin:20px 0;border: 5px solid rgba(255, 174, 67,0.5);padding: 10px;border-radius: 20px;">
        <div style="display:flex;flex-direction: row;justify-content: space-around;align-items: center;">
            <xsl:element name="img">
                <xsl:attribute name="src">
                    skills/<xsl:value-of select="./@image"/>
                </xsl:attribute>
            </xsl:element>
            <b style="font-size:30px;color:#ffae43;"><xsl:value-of select="./name"/></b>
        </div>
            <br/>
            <xsl:value-of select="./description"/>
            <br/>
        <div style="margin:10px 0;display:flex;flex-direction: row;justify-content: space-around;align-items: center;
        background-color:#8c8484;padding:10px;border-radius:20px;color:#c3290d;font-size:30px;">
            <xsl:element name="img">
                <xsl:attribute name="src">
                    skills/<xsl:value-of select="rune/@image"/>
                </xsl:attribute>
            </xsl:element>
            <xsl:value-of select="rune/name"/>
        </div>
            <xsl:value-of select="rune/description"/>
        
    </div>
    <!-- <xsl:value-of select=".[@type = 'passive']/@type"/> -->

</xsl:template>

<xsl:template match="skill[@type = 'passive']">
    
    <xsl:if test="position() = 7">
        <h4>Passive Skills</h4>
    </xsl:if>
    <div style="width:25ch;margin:20px 0;border: 5px solid rgba(255, 174, 67,0.5);padding: 10px;border-radius: 20px;">   
        <div style="display:flex;flex-direction: column;justify-content: space-around;align-items: center;">
            <xsl:element name="img">
                <xsl:attribute name="src">
                    skills/<xsl:value-of select="./@image"/>
                </xsl:attribute>
            </xsl:element>
            <b style="font-size:30px;color:#ffae43;margin-top:10px;"><xsl:value-of select="./name"/></b>
        </div>
            <br/>
            <xsl:value-of select="./description"/>        
    </div>
    <br/>
    <!-- <xsl:value-of select=".[@type = 'passive']/@type"/> -->

</xsl:template>

<!-- END of SKILLS -->

<!-- GEAR -->
<xsl:template match="item">
    <div style="width:300px;text-align:center;border: 5px solid rgba(255, 174, 67,0.5);padding: 10px;border-radius: 20px;margin: 20px 0;
    display:flex;flex-direction:column;justify-content:flex-start;align-items:center;">
    <h4 style="font-size:30px;color:#ffae43;margin-top:10px;">
    <xsl:value-of select="./name"/> (<xsl:value-of select="./set/@type"/>)
    </h4>
    <p style="margin: 10px 0;font-size: 20px;">
    <xsl:value-of select="./rarity/@set"/>&#160;<xsl:value-of select="./set"/>
    </p>
    <div>
        <xsl:attribute name="style">
            background-color:<xsl:value-of select="./rarity"/>;width:100px;height:140px;border-radius: 20px;border: 5px solid #793d26;margin: 0 0 20px 0                 
        </xsl:attribute>
        <xsl:element name="img">
            <xsl:attribute name="src">
                gear/<xsl:value-of select="./@image"/>
            </xsl:attribute>
            <xsl:attribute name='color'>#FFD700</xsl:attribute>
            
        </xsl:element>
    </div>
    <div  style="">
        <p style="font-size:22px;">
        Level requirements
        </p>
        <p style="color:white;font-size:40px;margin: 10px 0">
             <xsl:value-of select="requirements/level"/><br/>
        </p>
        
            <xsl:if test="stats/attack">
                <div style="color:white;font-size:40px;margin: 10px 0;display:flex;flex-direction:column;background-color:rgba(140,132,132,0.5);padding: 10px;border-radius: 20px;">
                    <b style="font-size:30px;color:#c3290d;margin: 15px 0;">DPS</b> <xsl:value-of select="stats/attack/dps"/>
                    <b style="font-size:30px;color:#c3290d;margin: 15px 0;">DMG</b><xsl:value-of select="stats/attack/damage"/>
                    <b style="font-size:30px;color:#c3290d;margin: 15px 0;">APS</b><xsl:value-of select="stats/attack/aps"/>
                </div>
            </xsl:if>
            <xsl:if test="stats/defense">
                <div style="color:white;font-size:40px;margin: 10px 0;display:flex;flex-direction:column;background-color:rgba(140,132,132,0.5);padding: 10px;border-radius: 20px;">
                    <b style="font-size:30px;color:#c3290d;margin: 15px 0;">Armor</b>&#160; <xsl:value-of select="stats/defense/armor"/>
                </div>
            </xsl:if>
        
    </div>
    <div>
        <xsl:if test="stats/primary">
        <hr style="color:white;color:#a81609;"/>
        <p style="font-size:30px;color:#ffae43">
            Primary Stats
        </p>
        <hr style="color:white;color:#a81609;"/>
        <div style="text-align:left;color:white;">    
        <ul>
            <xsl:for-each select="stats/primary/stat">
                <li style="margin: 10px 0;">
                    <xsl:value-of select="."/>
                </li>
            </xsl:for-each>
        </ul>
    </div>
        </xsl:if>
        <xsl:if test="stats/primary">
        <hr style="color:white;color:#a81609;"/>
        <p style="font-size:30px;color:#ffae43">
            Secondary Stats
        </p>
        <hr style="color:white;color:#a81609;"/>
        <div style="text-align:left;color:white;"> 
        <ul>
            <xsl:for-each select="stats/secondary/stat">
                <li style="margin: 10px 0;">
                    <xsl:value-of select="."/>
                </li>
            </xsl:for-each>
        </ul>
        </div>
        </xsl:if>
    </div>
    </div>
    <br/>
</xsl:template>
<!-- END GEAR -->

<xsl:template match="tag">
    <xsl:value-of select="."/>
</xsl:template>

</xsl:stylesheet>