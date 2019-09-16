/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataManage;

import java.util.ArrayList;

import mainPackage.Movie;

/**
 *
 * @author leoni
 */
public interface IDataManager 
{
    public abstract void manage() ;

	public abstract ArrayList<Movie> getMovie1();
}
