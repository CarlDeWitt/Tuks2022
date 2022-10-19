<?xml version="1.0"?>
<!-- Carl de Witt -->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" version="1.0">
	
	<xsl:output method="xml" indent="yes" />
	
	<xsl:template match="/">
		<fo:root>
			<fo:layout-master-set>
				<!--<fo:simple-page-master master-name="cover" page-height="148mm" page-width="210mm">
					<fo:region-body margin-top="10mm"  margin-bottom="3cm"/>
				</fo:simple-page-master>-->

				<fo:simple-page-master master-name="content" page-height="148mm" page-width="210mm">
					<fo:region-body margin="10mm"/>
					<fo:region-before extent="10mm" background-color="red"/>
					<fo:region-after extent="10mm" background-color="red"/>
					<fo:region-start />
					<fo:region-end />
				</fo:simple-page-master>
			</fo:layout-master-set>
			
			<xsl:for-each select="pokedex/pokemon">			
				<fo:page-sequence master-reference="content" force-page-count="no-force">

					<fo:static-content flow-name="xsl-region-before">
						<fo:block  font-family="serif" color="white">
							<!-- <xsl:value-of select="../animals/@publication" /> -->
							My Minidex
						</fo:block>
					</fo:static-content>

					<fo:static-content flow-name="xsl-region-after">
						<fo:block  font-family="serif" background-color="red" color="white" text-align="right">
							Page <fo:page-number/>
						</fo:block>
					</fo:static-content>

					<fo:flow flow-name="xsl-region-body">
						<fo:block >
							<fo:table>
								<fo:table-body>
									<fo:table-row>
										<fo:table-cell margin-right="40" width="240">
											<!-- left side of page -->
											<!-- names here -->
											<fo:block padding="10">
												#<xsl:value-of select="pokedex_number"/> &#160;<xsl:value-of select="species"/>
											</fo:block>

											<!-- images here -->
											
												<fo:block>
												<fo:external-graphic>
													<xsl:attribute name="src">
														./images/normal/front/<xsl:value-of select="pokedex_number"/>.<xsl:value-of select="image/normal/@type"/>
													</xsl:attribute>
													
												</fo:external-graphic>
												<fo:external-graphic>
													<xsl:attribute name="src">
														./images/normal/back/<xsl:value-of select="pokedex_number"/>.<xsl:value-of select="image/normalback/@type"/>
													</xsl:attribute>
													
												</fo:external-graphic>
												<!-- ./images/normal/front/<xsl:value-of select="pokedex_number"/>.<xsl:value-of select="image/normal/@type"/> -->
												</fo:block>
											

			
														
												<fo:block>
								
												<fo:external-graphic>
													<xsl:attribute name="src">
														./images/shiny/front/<xsl:value-of select="pokedex_number"/>.<xsl:value-of select="image/rare/@type"/>
													</xsl:attribute>
												</fo:external-graphic>
												
												<fo:external-graphic>
													<xsl:attribute name="src">
														./images/shiny/back/<xsl:value-of select="pokedex_number"/>.<xsl:value-of select="image/rareback/@type"/>
													</xsl:attribute>
												</fo:external-graphic>
											</fo:block>

											<fo:block border="3px solid gold" padding="10px" width="20">
												<fo:block  width="20">
													<fo:inline font-weight="bold">Attack: </fo:inline><xsl:value-of select="base_stats/atk"/>
												</fo:block>
												<fo:block  width="20">
													 <fo:inline font-weight="bold">Defense: </fo:inline><xsl:value-of select="base_stats/def"/>
												
												</fo:block>
												<fo:block  width="20">
													 <fo:inline font-weight="bold">SP. Attack: </fo:inline><xsl:value-of select="base_stats/satk"/>
													
												</fo:block>
												<fo:block  width="20">
													<fo:inline font-weight="bold">Sp. Defense: </fo:inline><xsl:value-of select="base_stats/sdef"/>
													
												</fo:block>
												<fo:block  width="20">
													 <fo:inline font-weight="bold">Speed: </fo:inline><xsl:value-of select="base_stats/spd"/>
													
												</fo:block>
												<fo:block  width="20">
												<fo:inline font-weight="bold">Average: </fo:inline><xsl:value-of select="(base_stats/atk + base_stats/def + base_stats/satk +base_stats/sdef + base_stats/spd) div 5"/>													
												</fo:block>
											</fo:block>
									
										</fo:table-cell>
										<fo:table-cell>
											<fo:block border="3px solid pink"  padding="10">
												<fo:block>
													Evolution chain
												</fo:block>
													
												<fo:external-graphic>
													<xsl:attribute name="src">
														./images/normal/front/<xsl:value-of select="pokedex_number"/>.<xsl:value-of select="image/rareback/@type"/>
													</xsl:attribute>
													<xsl:attribute name="width">
														60
													</xsl:attribute>
												</fo:external-graphic>
												<fo:external-graphic>
													<xsl:attribute name="src">
														./images/to.png
													</xsl:attribute>
													<xsl:attribute name="width">
														20
													</xsl:attribute>
												</fo:external-graphic>
												<fo:external-graphic>
													<xsl:attribute name="src">
														./images/normal/front/00<xsl:value-of select="pokedex_number + 1"/>.<xsl:value-of select="image/rareback/@type"/>
													</xsl:attribute>
													<xsl:attribute name="width">
														60
													</xsl:attribute>
												</fo:external-graphic>
												<fo:external-graphic>
													<xsl:attribute name="src">
														./images/to.png
													</xsl:attribute>
													<xsl:attribute name="width">
														20
													</xsl:attribute>
												</fo:external-graphic>
												<fo:external-graphic>
													<xsl:attribute name="src">
														./images/normal/front/00<xsl:value-of select="pokedex_number + 2"/>.<xsl:value-of select="image/rareback/@type"/>
													</xsl:attribute>
												</fo:external-graphic>
											</fo:block>

											<fo:block border="3px solid blue" margin-top="10" padding="10">
												<fo:inline font-weight="bold">Type: </fo:inline>
												<xsl:for-each select="types/type">
													<xsl:if test=".[position() = last()]">
														<xsl:value-of select="."/> 
													</xsl:if>
													<xsl:if test=".[position() != last()]">
														<xsl:value-of select="."/> |
													</xsl:if>
													
												</xsl:for-each>
											</fo:block>

											<fo:block border="3px solid brown" margin-top="10" padding="10">
												
												<fo:block margin-top="10">
												<fo:inline font-weight="bold">Height: </fo:inline><xsl:value-of select="size/height/inches"/> inches <xsl:value-of select="size/height/meters"/> meters
												</fo:block>

												<fo:block margin-top="10">
												<fo:inline font-weight="bold">Weight: </fo:inline><xsl:value-of select="size/weight/pounds"/> pounds <xsl:value-of select="size/weight/kilograms"/> kilograms
												</fo:block>

												<fo:block margin-top="10">
												<fo:inline font-weight="bold">Size: </fo:inline><xsl:value-of select="size/size_category"/>
												</fo:block>
													
												
											</fo:block>

											<fo:block border="3px solid orange" margin-top="10" padding="10" >
												<fo:inline font-weight="bold">Capture rate </fo:inline><xsl:value-of select="capture_rate"/> | <xsl:value-of select="exp_drop"/><fo:inline font-weight="bold"> EXP drop</fo:inline>
											</fo:block>
										</fo:table-cell>
									</fo:table-row>
								</fo:table-body>
							</fo:table>
						</fo:block>
					</fo:flow>
				</fo:page-sequence>	
			</xsl:for-each>

			
		</fo:root>
	</xsl:template>

	<!--templates can come down here -->
	
</xsl:stylesheet>