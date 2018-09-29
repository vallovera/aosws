package com.example.demo;
import java.io.Serializable;



public class Atividade implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int id;
	public String nome;
	
	
	public Atividade() {}
	
	public Atividade(int Id, String Nome)
	{
		id = Id;
		nome = Nome;
	}
}
