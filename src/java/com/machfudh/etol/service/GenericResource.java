/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.machfudh.etol.service;

import com.machfudh.etol.dao.KartuDao;
import com.machfudh.etol.dao.MesinDao;
import com.machfudh.etol.dao.SensorDao;
import com.machfudh.etol.dao.impl.KartuDaoImpl;
import com.machfudh.etol.dao.impl.MesinDaoImpl;
import com.machfudh.etol.dao.impl.SensorDaoImpl;
import com.machfudh.etol.entity.Mesin;
import com.machfudh.etol.entity.Sensor;
import com.machfudh.etol.util.DBUtil;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author user
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

        
    //test GET 
    
    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg){
        String output = " Hello Jersey : "+msg;
        
        System.out.println(output);
        
        
        return Response.status(Response.Status.OK).entity(output).build();
    }
    
    @GET
    @Path("/getsaldo/{kodekartu}/{kodemesin}")
    public Response getSaldo(@PathParam("kodekartu") String kodekartu,
                             @PathParam("kodemesin") String kodemesin ){
        
        String output = "";
        
        Mesin mesin = new Mesin();
        int saldo = 0;
        int sisasaldo = 0;
        String status = "0"; // dana kurang
        boolean update = false;
        DBUtil utilsaldo = new DBUtil();
        
        KartuDao kartuDao = new KartuDaoImpl(utilsaldo.getConn());
        MesinDao mesinDao = new MesinDaoImpl(utilsaldo.getConn());
        
        try{
            saldo = kartuDao.cekSaldo(kodekartu);
            
            mesin = mesinDao.cekMesin(kodemesin);
            
            if(saldo - mesin.getPotongan() >= 0 ){
                status = "1";
                update = kartuDao.potSaldo(kodekartu, saldo, mesin.getPotongan());
                sisasaldo = saldo - mesin.getPotongan();
                
            }else{
                status = "0";
                sisasaldo = saldo;
            }
            output = status+Integer.toString(sisasaldo);
            
        }catch(Exception ex){
            
        }finally{
            utilsaldo.closeConn();
        }
        return Response.status(Response.Status.OK).entity(output).build();
    }
    
    
    @GET
    @Path("/getsensor/{clientid}/{roomid}")
    public Response getSensor(@PathParam("clientid") int clientid,
                             @PathParam("roomid") int roomid){
       
        String output = "";
        Sensor sensor = new Sensor();
        
        DBUtil utilsensor = new DBUtil();
        SensorDao sensorDao = new SensorDaoImpl(utilsensor.getConn());
        try{
            
            sensor = sensorDao.getSensor(clientid, roomid);
            
            output = Integer.toString(sensor.getBtn1())+Integer.toString(sensor.getBtn2())+Integer.toString(sensor.getBtn3())+Integer.toString(sensor.getBtn4());
            
        }catch(Exception ex){
            
        }finally{
         utilsensor.closeConn();   
        }
        
        System.out.println(output);
        
        return Response.status(Response.Status.OK).entity(output).build();
    }
    
    @GET
    @Path("/setsensor/{clientid}/{roomid}/{status}/{btn1}/{btn2}/{btn3}/{btn4}/")
    public Response setSensor(@PathParam("clientid") int clientid,
                              @PathParam("roomid") int roomid,
                              @PathParam("status") String status,
                              @PathParam("btn1") int btn1,
                              @PathParam("btn2") int btn2,
                              @PathParam("btn3") int btn3,
                              @PathParam("btn4") int btn4){
        
        String output = "false";

        Sensor sensor = new Sensor();    
        boolean result = false;
        DBUtil utilSensor = new DBUtil();
        SensorDao sensorDao = new SensorDaoImpl(utilSensor.getConn());
        
        try{
            System.out.println(" kode btn : "+btn1+btn2+btn3+btn4);
            
            if(status.equalsIgnoreCase("u")){
            result = sensorDao.setSensor(clientid, roomid, btn1, btn2, btn3, btn4 );
            
            if(result){
                sensor = sensorDao.getSensor(clientid, roomid); 
                output = Integer.toString(sensor.getBtn1())+Integer.toString(sensor.getBtn2())+Integer.toString(sensor.getBtn3())+Integer.toString(sensor.getBtn4());
            
            }
            }else{
                sensor = sensorDao.getSensor(clientid, roomid); 
                output = Integer.toString(sensor.getBtn1())+Integer.toString(sensor.getBtn2())+Integer.toString(sensor.getBtn3())+Integer.toString(sensor.getBtn4());
           }                 
        }catch(Exception ex){
            
        }finally{
            utilSensor.closeConn();
        }

        return Response.status(Response.Status.OK).entity(output).build();
        
    }
    
    
}
