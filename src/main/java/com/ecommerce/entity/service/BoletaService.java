package com.ecommerce.entity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Boleta;
import com.ecommerce.entity.Categoria;
import com.ecommerce.entity.DetalleBoleta;
import com.ecommerce.entity.DetalleBoletaPK;
import com.ecommerce.entity.repository.BoletaRepository;
import com.ecommerce.entity.repository.CategoriaRepository;
import com.ecommerce.entity.repository.DetalleBoletaRepository;

import jakarta.transaction.Transactional;

@Service
public class BoletaService {
	
	@Autowired
	private BoletaRepository repoBol;
	
	@Autowired
	private DetalleBoletaRepository repodeta;
	
	
	@Transactional
	public void registrarBoleta(Boleta bean) {
		try {
			//grabar Boleta
			repoBol.save(bean);
			//grabar detalle
			for(DetalleBoleta mhb:bean.getListaDetalleBol()) {
				DetalleBoletaPK pk=new DetalleBoletaPK();
				pk.setNumeroBoleta(bean.getNumeroBoleta());
				pk.setCodigoElec(mhb.getElec().getCodigoele());
				mhb.setPk(pk);
				repodeta.save(mhb);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public List<Boleta> listarTodosbole(){
		return repoBol.findAll();
	}
	


}
