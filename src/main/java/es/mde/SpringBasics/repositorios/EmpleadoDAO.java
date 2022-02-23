package es.mde.SpringBasics.repositorios;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.mde.SpringBasics.entidades.selfJoin.EmpleadoConEmpleado;

@RepositoryRestResource(path="empleados"
						,itemResourceRel="empleado"
						,collectionResourceRel="empleados")
public interface EmpleadoDAO extends JpaRepository<EmpleadoConEmpleado, UUID>{

}
