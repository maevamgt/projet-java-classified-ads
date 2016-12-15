package com.ecetech.bti4.itproject.classified.dao;

import java.sql.SQLException;

import com.ecetech.bti4.itproject.classified.beans.Association;
import com.ecetech.bti4.itproject.classified.common.DBAction;

public class AssociationDAO {

	// Afficher un User Association en fonction de son id
		public static Association getAssoUser(String idUser) throws SQLException {
			DBAction.DBConnexion();
			Association Resultat = new Association();
			String req = ("SELECT * FROM user JOIN association ON user.idUser=association.User_idUser WHERE idUser='"
					+ idUser + "'");
			try {
				DBAction.setRes(DBAction.getStm().executeQuery(req));
			} catch (SQLException ex) {
				System.out.println(req);
				System.out.println("Requ�te non valide " + ex.getErrorCode());
			}

			while (DBAction.getRes().next()) {
				Resultat.setIdUser(DBAction.getRes().getString(1));
				Resultat.setIdSocialUser(DBAction.getRes().getString(2));
				Resultat.setMailUser(DBAction.getRes().getString(3));
				Resultat.setMdpUser(DBAction.getRes().getString(4));
				Resultat.setEtatUser(DBAction.getRes().getString(5));
				Resultat.setDateInUser(DBAction.getRes().getDate(6));
				Resultat.setTypeUser(DBAction.getRes().getString(7));
				Resultat.setPermission_idPermission(DBAction.getRes().getString(8));
				Resultat.setNomAss(DBAction.getRes().getString(10));
				Resultat.setSiretAss(DBAction.getRes().getString(11));
				Resultat.setNumAdAss(DBAction.getRes().getInt(12));
				Resultat.setRueAdAss(DBAction.getRes().getString(13));
				Resultat.setCpAdAss(DBAction.getRes().getInt(14));
				Resultat.setVilleAdAss(DBAction.getRes().getString(15));
				Resultat.setTelAss(DBAction.getRes().getInt(16));
			}

			DBAction.DBClose();

			return Resultat;
		}
}
