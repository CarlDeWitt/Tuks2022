<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" version="1.0">
	
	<xsl:output method="xml" indent="yes" />
	
	<xsl:template match="/">
		<fo:root>
			<fo:layout-master-set>
				<fo:simple-page-master master-name="cover" page-height="80mm" page-width="210mm">
					<fo:region-body margin-top="10mm"  margin-bottom="3cm"/>
				</fo:simple-page-master>

				<fo:simple-page-master master-name="content" page-height="80mm" page-width="210mm">
					<fo:region-body margin="10mm"/>
					<fo:region-before extent="10mm" background-color="#ADD8E6"/>
					<fo:region-after extent="10mm" background-color="green"/>
					<fo:region-start extent="10mm" background-color="#ADD8E6" margin="10mm"/>
					<fo:region-end extent="10mm" background-color="green" margin="10mm"/>
				</fo:simple-page-master>
			</fo:layout-master-set>

			<fo:page-sequence master-reference="cover" force-page-count="no-force">
				<fo:flow flow-name="xsl-region-body">
					<fo:block >
						<fo:external-graphic src="url('images/logo.jpg')"/>
					</fo:block>
				</fo:flow>
			</fo:page-sequence>

			<xsl:for-each select="//animals/animal">
			<!--<fo:page-sequence master-reference="content" initial-page-number="0" force-page-count="no-force">-->
			<!--page does not work for some dam reason-->
			<fo:page-sequence master-reference="content">
				<fo:static-content flow-name="xsl-region-before">
					<fo:block background-color="#ADD8E6" font-family="serif" color="white">
						<!-- <xsl:value-of select="../animals/@publication" /> -->
						Animals Fact Guide
					</fo:block>
				</fo:static-content>
				<fo:static-content flow-name="xsl-region-after">
					<fo:block  font-family="serif" text-align="right">
						<fo:page-number/>
					</fo:block>
				</fo:static-content>

				

					<fo:flow flow-name="xsl-region-body" font-size="13pt">				
						<fo:table>
							<fo:table-body>
								<fo:table-row>
									<fo:table-cell width="2cm" height="5cm" top="5cm">
										<fo:block  text-align="center">
											<xsl:variable name="imgName" select="concat('image/',animal/@image)"/>
											<!--<xsl:value-of select="concat('image/',animal/@image)" />-->
											<fo:external-graphic  display-align="center"  width="2cm" height="3cm" src="{@src}" content-width="scale-down-to-fit"  border="1px solid black">
												<xsl:attribute name="src">
													url(images/<xsl:value-of select="@image"/>)
                                                </xsl:attribute>
											</fo:external-graphic>
										</fo:block>
									</fo:table-cell>
								
									<fo:table-cell width="14cm" margin-left="1cm">
										<fo:block>
											<fo:block font-weight="bold" font-family="serif">
												<xsl:value-of select="name" />
											</fo:block>

											<fo:block font-weight="bold" color="#ADD8E6" font-family="serif">							
												<xsl:value-of select="sciName" />					
											</fo:block>

											<fo:block background-color="#ADD8E6" font-family="serif"  padding="2mm 2mm 0 2mm">
												<xsl:value-of select="abstract" />
											</fo:block>

											<fo:block background-color="#ADD8E6" font-family="serif"  padding="0 2mm 2mm 2mm">
												<xsl:value-of select="abstract/@more" />
											</fo:block>

											<fo:block font-family="serif" margin-top="5mm"> 
												Tags: 
												<xsl:for-each  select="tags">
													<xsl:value-of separator="/" select="."/>

												</xsl:for-each>
											</fo:block>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>		
							</fo:table-body>
						</fo:table>
					</fo:flow>
			</fo:page-sequence>
		</xsl:for-each>

			

			
		</fo:root>
	</xsl:template>
	<xsl:template match="tags">
		
	</xsl:template>
	
</xsl:stylesheet>
