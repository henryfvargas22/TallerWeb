/* ========================================================================
 * Copyright 2014 monitor
 *
 * Licensed under the MIT, The MIT License (MIT)
 * Copyright (c) 2014 monitor

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 * ========================================================================


Source generated by CrudMaker version 1.0.0.201408112050

*/

package co.edu.uniandes.csw.monitor.member.persistence.converter;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;


import co.edu.uniandes.csw.monitor.member.logic.dto.MemberDTO;
import co.edu.uniandes.csw.monitor.member.persistence.entity.MemberEntity;

public abstract class _MemberConverter {

 
	private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
	public static MemberDTO entity2PersistenceDTO(MemberEntity entity){
		if (entity != null) {
			MemberDTO dto = new MemberDTO();
					dto.setId(entity.getId());
					dto.setName(entity.getName());
					dto.setFirstName(entity.getFirstName());
					dto.setLastName(entity.getLastName());
 
			    if(entity.getBirthDate() != null){
					dto.setBirthDate(DATE_FORMAT.format(entity.getBirthDate()));
				}	
					dto.setEnable(entity.getEnable());
					dto.setDocNumber(entity.getDocNumber());
					dto.setDocumenttypeId(entity.getDocumenttypeId());
					dto.setPartnerId(entity.getPartnerId());
			return dto;
		}else{
			return null;
		}
	}
	
	public static MemberEntity persistenceDTO2Entity(MemberDTO dto){
		if(dto!=null){
			MemberEntity entity=new MemberEntity();
					entity.setId(dto.getId());
			
					entity.setName(dto.getName());
			
					entity.setFirstName(dto.getFirstName());
			
					entity.setLastName(dto.getLastName());
			
 
			      try{ 
			        if(dto.getBirthDate() != null){
						entity.setBirthDate(DATE_FORMAT.parse(dto.getBirthDate()));
					}
				  } catch (Exception ex) {
                        Logger.getLogger(_MemberConverter.class.getName()).log(Level.SEVERE, null, ex);
                  }	
			
					entity.setEnable(dto.getEnable());
			
					entity.setDocNumber(dto.getDocNumber());
			
					entity.setDocumenttypeId(dto.getDocumenttypeId());
			
					entity.setPartnerId(dto.getPartnerId());
			
			return entity;
		}else {
			return null;
		}
	}
	
	public static List<MemberDTO> entity2PersistenceDTOList(List<MemberEntity> entities){
		List<MemberDTO> dtos=new ArrayList<MemberDTO>();
		for(MemberEntity entity:entities){
			dtos.add(entity2PersistenceDTO(entity));
		}
		return dtos;
	}
	
	public static List<MemberEntity> persistenceDTO2EntityList(List<MemberDTO> dtos){
		List<MemberEntity> entities=new ArrayList<MemberEntity>();
		for(MemberDTO dto:dtos){
			entities.add(persistenceDTO2Entity(dto));
		}
		return entities;
	}
}