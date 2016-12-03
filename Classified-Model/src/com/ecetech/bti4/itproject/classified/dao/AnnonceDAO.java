package com.ecetech.bti4.itproject.classified.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ecetech.bti4.itproject.classified.beans.Annonce;
import com.ecetech.bti4.itproject.classified.beans.User;
import com.ecetech.bti4.itproject.classified.common.DBAction;

public class AnnonceDAO {

	public static ArrayList<Annonce> getAllAnnonce() throws SQLException {
		DBAction.DBConnexion();
		ArrayList<Annonce> annonces = new ArrayList<>();
		String req = ("SELECT * FROM annonce;");

		try {
			DBAction.setRes(DBAction.getStm().executeQuery(req));
		} catch (SQLException ex) {
			System.out.println("prout " + ex.getErrorCode());
		}
		int i = 0;
		while (DBAction.getRes().next()) {
			
			Annonce annonce = (Annonce) DBAction.getRes();
			annonces.add(annonce);

		}

		DBAction.DBClose();

		return annonces;
	}
}
