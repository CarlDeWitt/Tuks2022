<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" version="1.0">
	
	<xsl:output method="xml" indent="yes" />
	
	<xsl:template match="/">
		<fo:root>
			<fo:layout-master-set>
				<fo:simple-page-master master-name="cover" page-height="29.7cm" page-width="21cm">
					<fo:region-body margin-top="10mm"  margin-bottom="3cm"/>
				</fo:simple-page-master>

				<fo:simple-page-master master-name="content" page-height="29.7cm" page-width="21cm">
					<fo:region-body margin="50mm 0 30mm 0" background-color="#000080"/>
					<fo:region-before extent="50mm" background-color="#010312"/>
					<fo:region-after extent="30mm" background-color="#010312"/>
					<fo:region-start  background-color="#403ffc"/>
					<fo:region-end  background-color="#403ffc"/>
				</fo:simple-page-master>
			</fo:layout-master-set>

			<fo:page-sequence master-reference="cover" force-page-count="no-force">
				<fo:flow flow-name="xsl-region-body">
					<fo:block >
						<fo:external-graphic src="url('background.jpg')"/>
					</fo:block>
				</fo:flow>
			</fo:page-sequence>

            <xsl:for-each select="schedule/event">
            
            <fo:page-sequence master-reference="content">
                <fo:static-content flow-name="xsl-region-after">
					<fo:block  font-family="serif" text-align="right" color="#ff7a27" font-size="50pt">
						<fo:page-number/>
					</fo:block>
				</fo:static-content>

                <fo:static-content flow-name="xsl-region-before">
					<fo:block  font-family="serif" color="#ff7a27"  text-align="center" font-size="60pt">
						<xsl:value-of select="event/title"/>
					</fo:block>
				</fo:static-content>
                
                
                <fo:flow flow-name="xsl-region-body" color="white">
                    <fo:table>
							<fo:table-body>
								<fo:table-row>
									<fo:table-cell margin="10mm">
                                        <fo:block font-size="40pt" margin-bottom="40px" color="#ff7a27">
                                            Type:
                                            <xsl:value-of select="type"/>&#10;
                                        </fo:block>
                                        <!-- Time -->
                                        <fo:block font-size="30pt" margin-bottom="30px">
                                            Date: <xsl:value-of select="date/day"/>/<xsl:value-of select="date/month"/>
                                        </fo:block>
                                        <fo:block font-size="30pt" margin-bottom="30px" background-color="green">
                                            Start Time:
                                            <xsl:value-of select="date/startingTime"/>
                                        </fo:block>

                                        <fo:block font-size="30pt" margin-bottom="30px" background-color="red">
                                            End Time: 
                                            <xsl:value-of select="date/endingTime"/>&#10;
                                        </fo:block>

                                        <fo:block  font-size="30pt" margin-bottom="30px">
                                           Venue: <xsl:value-of select="venue"/>&#10;
                                        </fo:block>
                                        <fo:block  font-size="30pt">
                                            Description:
                                        </fo:block>
                                        <fo:block  font-size="20pt">
                                            <xsl:value-of select="description"/>&#10;
                                        </fo:block>
                                    </fo:table-cell>
                                
									<fo:table-cell  margin="10mm">
                                            <fo:block  font-size="40pt" color="#ff7a27" margin-bottom="40px">
                                                Guests
                                            </fo:block>
                                            <xsl:for-each select="guests/guest">
                                            <fo:block  font-size="15pt">
                                                Name: <xsl:value-of select="name"/>&#10;
                                            </fo:block>
                                            <fo:block  font-size="15pt"  margin-bottom="10px">
                                                email: <xsl:value-of select="email"/>&#10;
                                            </fo:block>
                                            </xsl:for-each>
                                        
                                        <!-- Venue -->
                                        
                                    </fo:table-cell>
                                </fo:table-row>                                
                                <!-- Guest -->
                               

                         </fo:table-body>
                     </fo:table>
                </fo:flow>
                
            </fo:page-sequence>
            </xsl:for-each>
		</fo:root>
	</xsl:template>
	
</xsl:stylesheet>
