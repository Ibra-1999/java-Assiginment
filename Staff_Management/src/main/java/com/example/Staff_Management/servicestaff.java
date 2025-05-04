package com.example.Staff_Management;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
@Service
public class servicestaff {
    private Map<Long, classstaff> Staffs = new ConcurrentHashMap<>();

    private AtomicLong Atoid = new AtomicLong();

    public Collection<classstaff> allstaff(){
        return Staffs.values();
    }
    public classstaff getbyid(Long id){
        return Staffs.get(id);
    }
    public classstaff save(classstaff newStaff){
        Long Staffid = newStaff.getId() != null? newStaff.getId() : Atoid.incrementAndGet();
        newStaff.setId(Staffid);
        Staffs.put(Staffid,newStaff);
        return newStaff;
    }
    public classstaff update(Long id , classstaff newStaff) {
        if (Staffs.containsKey(id)) {
            classstaff olddata = getbyid(id);

            olddata.setName(newStaff.getName());
            olddata.setAddress(newStaff.getAddress());
            Staffs.put(id, olddata);
            return olddata;
        }
        else
            return null;
    }
    public classstaff DeleteStaff(Long id){
        return Staffs.remove(id);
    }
}
