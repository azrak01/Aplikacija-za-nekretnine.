package com.example.drugaparcijala;

import com.example.drugaparcijala.repository.NekretninaRepositoryImpl;
import com.example.drugaparcijala.repository.NekretninaRepository;
import com.example.drugaparcijala.repository.NekretninaRepository;
import com.example.drugaparcijala.repository.NekretninaRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Config {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    private static final EntityManager em = emf.createEntityManager();
    //public static final NekretninaRepository nekretninaRepository = new NekretninaRepositoryImpl(em);
}
