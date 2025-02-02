package com.cpena.previred.backend.apirest.domain.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "trabajadores")
@NoArgsConstructor
@Getter
@Setter
public class Trabajador implements Serializable{

	private static final long serialVersionUID = 3865586469933888797L;
	
	@Id
	@Column(name = "trabajador_id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "trabajador_id_seq")
	@SequenceGenerator(name = "trabajador_id_seq", sequenceName = "trabajador_id_seq", allocationSize = 1)
	private Long id;
	
	@Column(name = "rut_trabajador", unique = true)
	private Integer rut;
	
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;
	
	@Column(name = "apellido", nullable = false, length = 50)
	private String apellido;
	
	@Column(name = "direccion", length = 250)
	private String direccion;
	
	@Column(name = "fecha_inser")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creatAt;
	
	@Column(name = "fecha_modif")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateAt;	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;

	@Override
	public int hashCode() {
		return Objects.hash(apellido, creatAt, direccion, empresa, id, nombre, rut, updateAt);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trabajador other = (Trabajador) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(creatAt, other.creatAt)
				&& Objects.equals(direccion, other.direccion) && Objects.equals(empresa, other.empresa)
				&& Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(rut, other.rut) && Objects.equals(updateAt, other.updateAt);
	}
	
	
	
	

}
