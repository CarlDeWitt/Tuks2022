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
					<fo:region-before extent="10mm"/>
					<fo:region-after extent="10mm"/>
					<fo:region-start extent="10mm"/>
					<fo:region-end extent="10mm"/>
				</fo:simple-page-master>
			</fo:layout-master-set>

			<fo:page-sequence master-reference="cover" force-page-count="no-force">
				<fo:flow flow-name="xsl-region-body">
					<fo:block >
						<fo:external-graphic src="url('images/logo.jpg')"/><!--image here-->
					</fo:block>
				</fo:flow>
			</fo:page-sequence>	

			
		</fo:root>
	</xsl:template>

	<!--templates can come down here -->
	
</xsl:stylesheet>