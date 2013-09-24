<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <style type="text/css">
      html { height: 100% }
      body { height: 100%; margin: 0; padding: 0 }
      #map_canvas { height: 100% }
      #top {
	  position: fixed;
	  top: 0;
	  left: 0;
	  z-index: 999;
	  width: 100%;
	  height: 23px;
	}

	#statusDiv {
	   position:fixed;
	   left:0px;
	   bottom:0px;
	   height:30px;
	   width:100%;
	   background:#999;
	}

    </style>
    <script type="text/javascript"
      src="http://maps.googleapis.com/maps/api/js?key=AIzaSyAf78YpQTDPoklfb2VuToCLgoGJDIhBzU8&sensor=true&region=BR">
    </script>
    <link rel="stylesheet" type="text/css" href="/js/jquery-easyui-1.3.4/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/js/jquery-easyui-1.3.4/themes/icon.css">
    <script type="text/javascript" src="/wsouza/jquery-2.0.2.min.js"></script>
    <script type="text/javascript" src="/wsouza/polygon-estados.js"></script>
    <script type="text/javascript" src="/wsouza/base.js"></script>
    <script type="text/javascript" src="/js/jquery-easyui-1.3.4/jquery.easyui.min.js"></script>
    <script type="text/javascript">
      
   //var anosOcorrencia = ${anosOcorrencia};
  	var contextPath = "${pageContext.request.contextPath}";
    </script>
  </head>
  <body onload="initialize()">
            
            
  <div id="top" style="background-color:black;">
  <label style="color:white"><b>Ano:</b></label>
            <select id="anosDisponiveis" class="easyui-combobox" name="state" style="width:200px;" data-options="multiple:true, panelHeight:'auto'">
            <c:forEach var="ano" begin="2007" end="2012">
		        <option value="${ano}">${ano}</option>
            </c:forEach>
        
    		</select>
 <!--    <a id="anosOcorrenciaLink" style="color:white" href="javascript:void(0)"  > <label style="color:white"><b>Anos de ocorr&ecirc;ncia<b></label>  </a> -->
  
  <label style="color:white"><b> | </b></label>  
  <label style="color:white"><b>Estado:</b></label>
  <select id="estados" onchange="accioEstado($(this).val())">
  <option value="" selected="selected">--Selecione</option>
	<option value="AC" >Acre </option>
<option value="AL" >Alagoas </option>
<option value="AM" >Amazonas </option>
<option value="AP" >Amap&aacute; </option>
<option value="BA" >Bahia </option>
<option value="CE" >Cear&aacute; </option>
<option value="DF" >Distrito Federal </option>
<option value="ES" >Esp&iacute;rito Santo </option>
<option value="GO" >Goi&aacute;s </option>
<option value="MA" >Maranh&atilde;o </option>
<option value="MG" >Minas Gerais </option>
<option value="MS" >Mato Grosso do Sul </option>
<option value="MT" >Mato Grosso </option>
<option value="PA" >Par&aacute; </option>
<option value="PB" >Para&iacute;ba </option>
<option value="PE" >Pernambuco </option>
<option value="PI" >Piau&iacute; </option>
<option value="PR" >Paran&aacute; </option>
<option value="RJ" >Rio de Janeiro </option>
<option value="RN" >Rio Grande do Norte </option>
<option value="RO" >Rond&ocirc;nia </option>
<option value="RR" >Roraima </option>
<option value="RS" >Rio Grande do Sul </option>
<option value="SC" >Santa Catarina </option>
<option value="SE" >Sergipe </option>
<option value="SP" >S&atilde;o Paulo </option>
<option value="TO" >Tocantins </option>

  </select>

  <label style="color:white"><b>Rota:<b></label> 
  	
  	<input type="text" id="de" />  
  	
  	<label style="color:white"><b>At&eacute;:<b></label> 
  	
  	<input type="text" id="ate" />
  	
  	<input type="button" value="Buscar" onclick="accioRota()"/>
  
  </div>
 	<!-- <div class="demo-info">
        <div class="demo-tip icon-tip"></div>
        <div>Hover the links to display tooltip message.</div>
    </div> -->    
    
    <div id="map_canvas" style="width:100%; height:100%"></div>
    
     <div id="statusDiv" style="background-color:black;">
        
    </div>


<div style="display:none; " id="anoCheckedDiv">
	<c:forEach var="ano" begin="2007" end="2012">
	 <span style="background-color:#ecd084"><input type="checkbox"  checked="checked" class="anoCheck" onchange="checkAno(this)" value="${ano}"/>  ${ano} </span><br/>
	</c:forEach>
	
	
	
</div>
  </body>
</html>