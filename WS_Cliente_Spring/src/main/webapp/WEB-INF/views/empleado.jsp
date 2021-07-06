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

<div class="col-md-12">
		<div class="card">
		<div class="card-header">
		<div class="d-flex align-items-center">
	 	<h4 class="card-title">Listado de Empleados</h4>
	 	<button class="btn btn-primary btn-round ml-auto" data-toggle="modal" data-target="#modalCliente">
		<i class="fa fa-plus"></i> Agregar Empleado
		</button>
		</div>
		</div> 
		<div class="card-body">
		<div class="table-responsive">
			<table id="table" class="display table table-striped table-hover">
		        <thead>
		            <tr>
		                <th>Código</th>
		                <th>Nombre</th>
		                <th>Apellido</th>
		                <th>Sexo</th>
		                <th>Tipo Empleado</th>
		                <th style="width: auto;">Action</th>
		            </tr>
		        </thead>
		        <tbody>
				<c:forEach items="${requestScope.dataEmpleados}" var="row">
		            <tr>
		                <td>${row.codigoEmpleado}</td>
		                <td>${row.nombres}</td>
		                <td>${row.apellidos}</td>
		                <td>${row.sexo}</td>
		                <td>${row.tipoEmpleado.nombreTipoEmpleado}</td>
		                
		                <td>
		                <div class="form-button-action">
											<button type="button" data-toggle="tooltip" title="" class="btn btn-link btn-primary btn-lg" data-original-title="Editar" id="btnEditar">
											<i class="fa fa-edit"></i></button>
											<button type="button" data-toggle="tooltip" title="" class="btn btn-link btn-danger" data-original-title="Eliminar" id="btnEliminar">
											<i class="fa fa-times"></i>
											</button>
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
		        <h5 class="modal-title" id="idTitulo">REGISTRAR EMPLEADO</h5>
		      </div>
		      <div class="modal-body">
		        <form id="frmCliente" action="save" method="post" data-toggle="validator" role="form">
				  <input type="text" name="codigo" id="codigo" value="0">
				  
				  <div class="form-group">
				    <label for="exampleInputEmail1">Nombre</label>
				    <input type="text" class="form-control" name="nombre" id="nombre">
				  </div>
				  
				  <div class="form-group">
				    <label for="exampleInputEmail1">Apellido</label>
				    <input type="text" class="form-control" name="apellido" id="apellido">
				  </div>
				  
				  <div class="form-group">
				    <label for="exampleInputEmail1">Sexo</label>
				    <input type="text" class="form-control" name="sexo" id="sexo">
				  </div>
				  
				  
				  <div class="form-group">
				    <label for="exampleInputEmail1">Tipo Empleado</label>
				    <select class="form-control" name="tipo" id="tipo">
				      <option value=" ">[Seleccione Tipo]</option>
				    </select>
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
		    cargarTipo();
	} );
	
	
//---------------------------------COMBO-------------------------------------//	
function cargarTipo(){
	fetch("listaTipoEmpleado")
	.then(response=>response.json())
	.then(tipos=>{
		tipos.forEach(tipo=>{
				$("#tipo").append("<option value='"+ tipo.codigoTipoEmpleado+"'>"+
						tipo.nombreTipoEmpleado+"</option>");	
			})
	})
	
	
}

//---------------------------------ELIMINAR-------------------------------------//	
$(document).on("click",".btnEliminar",function(){

	
	

})
//---------------------------------EDITAR-------------------------------------//	
$(document).on("click","#btnEditar",function(){
	//obtener el còdigo de la computadora segùn la fila actual
	var cod;
	cod=$(this).parents("tr").find("td")[0].innerHTML;
	fetch("buscar?codigo="+cod)
	.then(response=>response.json())
	.then(empleado=>{
		//console.log(computadora);
		$("#codigo").val(empleado.codigoEmpleado);
		$("#nombre").val(empleado.nombres);
		$("#apellido").val(empleado.apellidos);
		$("#sexo").val(empleado.sexo);
		$("#tipo").val(empleado.tipoEmpleado.codigoTipoEmpleado);
	})
	
	$("#idTitulo").text("ACTUALIZAR EMPLEADO");
	$('#modalCliente').modal({backdrop: 'static',keyboard:false,show:true});

	    
});	


//---------------------------------CERRAR-------------------------------------//	
$(document).on("click","#cerrar",function(){
	$('#frmCliente').trigger("reset");
	$('#frmCliente').data('bootstrapValidator').resetForm(true);
	$("#codigo").val("0");		
	$("#idTitulo").text("REGISTRAR EMPLEADO");
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