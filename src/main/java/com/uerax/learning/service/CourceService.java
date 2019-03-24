package com.uerax.learning.service;

import com.uerax.learning.domain.Cource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author uerax
 * @date 2019/3/19 21:09
 */
public interface CourceService {
    public List<Cource> getCource(Cource cource);
    public List<Cource> getAllCource();
    public void updateCourceSection(Cource cource);
    public void deleteCource(Cource cource);
    public void addCource(Cource cource);
    public Cource getCourceById(Cource cource);
    public List<Cource> getCourceByClassify(Cource cource);
}
