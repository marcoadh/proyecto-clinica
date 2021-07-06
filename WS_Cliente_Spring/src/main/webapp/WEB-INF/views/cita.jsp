<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalTime"%>
<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="<c:url value="/resources/img/icon.ico" />" type="image/x-icon"/>
 <script src="https://kit.fontawesome.com/20a78a26ae.js" crossorigin="anonymous"></script>
	<!-- Fonts and icons -->
	<script src="<c:url value="/resources/js/webfont.min.js"/>"></script>
	<script>
		WebFont.load({
			google: {"families":["Lato:300,400,700,900"]},
			custom: {"families":["Flaticon", "Font Awesome 5 Solid", "Font Awesome 5 Regular", "Font Awesome 5 Brands", "simple-line-icons"], urls: ['/resources/css/fonts.min.css']},
			active: function() {
				sessionStorage.fonts = true;
			}
		});
	</script>
    <link rel="stylesheet" href="<c:url value="/resources/css/fonts.min.css" />">
	<!-- CSS Files -->
	<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
	<link rel="stylesheet" href="<c:url value="/resources/css/atlantis.min.css" />">
        <title>JSP Page</title>  
<style>
	
	.form-group.has-error .form-control-label {
	  color: red;
	}
	
	.form-group.has-error .form-control {
	  border: 1px solid red;
	  box-shadow: 0 0 0 0.2rem rgba(250, 16, 0, 0.18);
	}

</style>
</head>
<body>
<!-- The Modal -->
	  <div class="modal fade" id="modalEliminar" data-backdrop="static">
	    <div class="modal-dialog modal-dialog-centered" role="document">
	      <div class="modal-content">
	        <!-- Modal Header -->
	        <div class="modal-header">
	          <h4 class="modal-title">Sistema</h4>
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	        </div>
	        
	        <!-- Modal body -->
	        <div class="modal-body">
	        	Seguro de eliminar Cita? 
	        </div>
	        
	        <!-- Modal footer -->
	        <div class="modal-footer">
	          <form action="" method="post" name="myForm">	
			  	  <a class="btn btn-primary" id="btnEliminar">Si</a>
		          <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>		           
	          </form>
	        </div>
	        
	      </div>
	    </div>
	  </div>


	<div class="container">
	<c:if test="${MENSAJE !=null}">
	<div class="alert alert-warning alert-dismissible fade show" role="alert" id="success-alert">
	  <strong>Sistema:</strong> ${MENSAJE}
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>
	</c:if>
	<c:remove var="MENSAJE"/>
	
<div class="col-md-12">
		<div class="card">
		<div class="card-header">
		<div class="d-flex align-items-center">
	 	<h4 class="card-title">Listado de Citas</h4>
	 	<button class="btn btn-primary btn-round ml-auto" data-toggle="modal" data-target="#modalCliente">
		<i class="fa fa-plus"></i> Agregar Cita
		</button>
		</div>
		</div> 
		<div class="card-body">
		<div class="table-responsive">
			<table id="table" class="display table table-striped table-hover">
		        <thead>
		            <tr>
		                <th>Código</th>
		                <th>DNI</th>
		                <th>Nombre</th>
		                <th>Apellido</th>
		                <th>Asunto</th>
		                <th>Enfermedad</th>
		                <th>Sintomas</th>
		                <th>Fecha Registro</th>
		                <th style="width: auto;">Accion</th>
		            </tr>
		        </thead>
		        <tbody>
				<c:forEach items="${requestScope.dataCitas}" var="row">
		            <tr>
		                <td>${row.codigoCita}</td>
		                <td>${row.paciente.dni}</td>
		                <td>${row.paciente.nombre}</td>
		                <td>${row.paciente.apellido}</td>
		                <td>${row.asunto}</td>
		                <td>${row.enfermedad}</td>
		                <td>${row.sintomas}</td>
		                <td>${row.fechaRegistro}</td>
		                <td>
		                <div class="form-button-action">
											<button type="button" data-toggle="tooltip" title="" class="btn btn-link btn-primary btn-lg" data-original-title="Editar" id="btnEditar">
											<i class="fa fa-edit"></i></button>
											<a href="delete/${row.codigoCita}" data-toggle="tooltip" title="" class="btn btn-link btn-danger" data-original-title="Eliminar" id="eliminar">
											<i class="fa fa-times"></i>
											</a>
						</div>
						</td>
     		            </tr>
				</c:forEach>
		        </tbody>
	    	</table>	
	    	</div>	
		</div>
		</div>
	</div>
		
		<!-- Modal -->
		<div class="modal fade" id="modalCliente" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="idTitulo">REGISTRAR CITA</h5>
		      </div>
		      <div class="modal-body">
		        <form id="frmCliente" action="save" method="post" data-toggle="validator" role="form">
				  <input type="text" name="codigo" id="codigo" value="0">
				  
				  <div class="form-group">
				    <label for="exampleInputEmail1">Paciente</label>
				    <select class="form-control" name="paciente" id="paciente">
				      <option value=" ">[Seleccione datos de Paciente]</option>
				    </select>
				  </div>
				  
				  <div class="form-group">
				    <label for="exampleInputEmail1">Asunto</label>
				    <input type="text" class="form-control" name="asunto" id="asunto">
				  </div>
				   <div class="form-group">
				    <label for="exampleInputEmail1">Enfermedad</label>
				    <input type="text" class="form-control" name="enfermedad" id="enfermedad">
				  </div>
				   <div class="form-group">
				    <label for="exampleInputEmail1">Sintomas</label>
				    <input type="text" class="form-control" name="sintomas" id="sintomas">
				  </div>
				   <div class="form-group">
				    <label for="exampleInputEmail1">Fecha Registro</label>
						<input type="datetime-local" class="form-control" name="fechaRegistro"  readonly="readonly" id="fechaRegistro">
				  </div>
				  			  
				  <div class="modal-footer no-bd">
			        <button type="button" class="btn btn-danger" data-dismiss="modal" id="cerrar">Cerrar</button>
			        <button type="submit" class="btn btn-primary">Guardar</button>
			      </div>	
				</form>
		      </div>
		    </div>
		  </div>
		</div>
	 	</div>
	
	
		<!--   Core JS Files   -->
	<script src="<c:url value="/resources/js/core/jquery.3.2.1.min.js" />"></script>
	<script src="<c:url value="/resources/js/core/popper.min.js" />"></script>
	<script src="<c:url value="/resources/js/core/bootstrap.min.js" />"></script>

	<!-- jQuery UI -->
	<script src="<c:url value="/resources/js/plugin/jquery-ui-1.12.1.custom/jquery-ui.min.js" />"></script>
	<script src="<c:url value="/resources/js/plugin/jquery-ui-touch-punch/jquery.ui.touch-punch.min.js" />"></script>

	<!-- jQuery Scrollbar -->
	<script src="<c:url value="/resources/js/plugin/jquery-scrollbar/jquery.scrollbar.min.js" />"></script>


	<!-- Chart JS -->
	<script src="<c:url value="/resources/js/plugin/chart.js/chart.min.js" />"></script>

	<!-- jQuery Sparkline -->
	<script src="<c:url value="/resources/js/plugin/jquery.sparkline/jquery.sparkline.min.js" />"></script>

	<!-- Chart Circle -->
	<script src="<c:url value="/resources/js/plugin/chart-circle/circles.min.js" />"></script>

	<!-- Datatables -->
	<script src="<c:url value="/resources/js/plugin/datatables/datatables.min.js" />"></script>
	<!-- Atlantis JS -->
	<script src="<c:url value="/resources/js/atlantis.min.js" />"></script>


	
<script type="text/javascript">
	
	$(document).ready(function() {
			$("#table").DataTable({
				"columnDefs": [{
					"targets": 0
				}],
				language: {
					"sProcessing": "Procesando...",
					"sLengthMenu": "Mostrar _MENU_ resultados",
					"sZeroRecords": "No se encontraron resultados",
					"sEmptyTable": "Ningún dato disponible en esta tabla",
					"sInfo": "Mostrando resultados _START_-_END_ de  _TOTAL_",
					"sInfoEmpty": "Mostrando resultados del 0 al 0 de un total de 0 registros",
					"sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
					"sSearch": "Buscar:",
					"sLoadingRecords": "Cargando...",
					"oPaginate": {
						"sFirst": "Primero",
						"sLast": "Último",
						"sNext": "Siguiente",
						"sPrevious": "Anterior"
					},
				}
				});
			cargarPaciente();
			completarHoraInicio();
	} );
	
	
//---------------------------------COMBO-------------------------------------//	


<!--script-->
function completarHoraInicio(){
    var fecha = new Date(); //Fecha actual
    var mes = fecha.getMonth()+1; //obteniendo mes
    var dia = fecha.getDate(); //obteniendo dia
    var ano = fecha.getFullYear(); //obteniendo año
    var hora = fecha.getHours(); //obteniendo hora
    var minutos = fecha.getMinutes(); //obteniendo minuto

    document.getElementById("fechaRegistro").value=ano+"-"+minTwoDigits(mes)+"-"+minTwoDigits(dia)+"T"+minTwoDigits(hora)+":"+minTwoDigits(minutos);
}

function minTwoDigits(n) {
  return (n < 10 ? '0' : '') + n;
}


function cargarPaciente(){
	fetch("listaPaciente")
	.then(response=>response.json())
	.then(pacientes=>{
		pacientes.forEach(paciente=>{
				$("#paciente").append("<option value='"+ paciente.codigoPaciente+"'>"+
						paciente.nombre+", "+paciente.apellido+"</option>");	
			})
	})
	
	
}

//---------------------------------ELIMINAR-------------------------------------//	
$(document).on("click","#eliminar",function(){
	//evento por defecto
	event.preventDefault();
	//obtener el href del botòn seleccionado
	var ruta;
	ruta=$(this).attr("href");
	//enviar el valor de la variable "href" al ID "btnEliminar"
	$("#btnEliminar").attr("href",ruta);
	$("#modalEliminar").modal("show");

})
//---------------------------------EDITAR-------------------------------------//	
$(document).on("click","#btnEditar",function(){
	//obtener el còdigo de la computadora segùn la fila actual
	var cod;
	cod=$(this).parents("tr").find("td")[0].innerHTML;
	fetch("buscar?codigo="+cod)
	.then(response=>response.json())
	.then(cita=>{
		$("#codigo").val(cita.codigoCita);
		$("#asunto").val(cita.asunto);
		$("#enfermedad").val(cita.enfermedad);
		$("#sintomas").val(cita.sintomas);
		$("#fechaRegistro").val(cita.fechaRegistro);
		$("#paciente").val(cita.paciente.codigoPaciente);
	})
	
	$("#idTitulo").text("ACTUALIZAR CITA");
	$('#modalCliente').modal({backdrop: 'static',keyboard:false,show:true});

	    
});	


//---------------------------------CERRAR-------------------------------------//	
$(document).on("click","#cerrar",function(){
	$('#frmCliente').trigger("reset");
	$('#frmCliente').data('bootstrapValidator').resetForm(true);
	$("#codigo").val("0");		
	$("#idTitulo").text("REGISTRAR CITA");
	$('#modalCliente').modal("hide");
})

</script>

<!--
<script type="text/javascript">    
    $(document).ready(function(){     
        $('#frmComputadora').bootstrapValidator({      
        	 fields:{
        		 descripcion:{
        			 	validators:{
        			 		notEmpty:{
        			 			message:'Campo nombre es obligatorio'	
        			 		},
        			 		regexp:{
        			 			regexp:/^[a-zA-Z\s\ñ\Ñ\á\é]{3,15}$/,
        			 			message:'Campo nombre solo letras min 3 hasta max 15 letras'
        			 		}
        			 	}
        		 },   
     		 	cantidad:{
     			 	validators:{
     			 		notEmpty:{
     			 			message:'Campo cantidad es obligatorio'	
     			 		},
     			 		digits:{
     			 			message:'Campo cantidad solo digitos'
     			 		},
     			 		regexp:{
    			 			regexp:/^(\d|[1-5][0-9])$/,
    			 			message:'Campo cantidad max 59'
    			 		}
     			 	}
     		 	 },  
     		 	datepicker:{
     			 	validators:{
     			 		notEmpty:{
     			 			message:'Campo fecha es obligatorio'	
     			 		}
     			 	}
     		 	 },
     		 	precio:{
     			 	validators:{
     			 		notEmpty:{
     			 			message:'Campo precio es obligatorio'	
     			 		},
     			 		regexp:{
    			 			regexp:/^\d{1,}\.\d{1,2}$/,
    			 			message:'Campo precio min 3 cifras'
    			 		}
     			 	}
     		 	 },    
     		 	marca:{
     			 	validators:{
     			 		notEmpty:{
     			 			message:'Campo marca es obligatorio'	
     			 		}
     			 	}
     		 	 },    
     		 	 
     		 	 
        	 }
        });   
			
    });    
</script>
	
	-->
	
	
</body>
</html>