///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.NouvelleDAO to edit this template
// */
//package dao;
//
//import entities.Nouvelle;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Collection;
//
///**
// *
// * @author Thaïs GENIN
// */
//public class NouvelleDAO extends DAO<NouvelleDAO> {
//
//    public NouvelleDAO() {
//        super("nouvelle");
//    }
//
//        @Override
//    protected Nouvelle createObject(ResultSet rs) throws SQLException {
//            Nouvelle nouv = new Nouvelle();
//            nouv.setId_Nouvelle(rs.getInt("id_Nouvelle"));
//            nouv.setTitre(rs.getString("titre"));
//            nouv.setContenu(rs.getString("contenu"));
//            nouv.setDate_publication(rs.getTimestamp("date_publication"));
//            nouv.set(DAOFactory.getUtilisateurDao().read(rs.getInt("utilisateur")));
//            return nouv;
//        }
//
//        @Override
//    public void create(Nouvelle art) {
//            String sql = "INSERT INTO " + table + " (title, content, created, author) VALUES (?, ?, ?, ?)";
//            try (PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
//                pstmt.setString(1, art.getTitre());
//                pstmt.setString(2, art.getContenu());
//                pstmt.setTimestamp(3, art.getDate_publication());
//                pstmt.setInt(4, art.getUtilisateur().getId());
//                int nbLines = pstmt.executeUpdate();
//                if (nbLines == 1) {
//                    ResultSet autoGeneratedKeys = pstmt.getGeneratedKeys();
//                    autoGeneratedKeys.first();
//                    int id = autoGeneratedKeys.getInt(1);
//                    nouv.setId(id);
//                }
//            } catch (SQLException ex) {
//                System.err.println("Erreur lors de l'insertion : " + ex.getMessage());
//            }
//        }
//
//        @Override
//    protected void update(Nouvelle art) {
//            String sql = "UPDATE " + table + " SET id_article=?,"
//                    + "title=?," + "content=?," + "created=?,"
//                    + "author=?, WHERE id_" + table + "=?";
//            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
//                pstmt.setInt(1, art.getId());
//                pstmt.setString(2, art.getTitle());
//                pstmt.setString(3, art.getContent());
//                pstmt.setTimestamp(4, art.getCreated());
//                pstmt.setInt(5, art.getAuthor().getId());
//
//                pstmt.executeUpdate();
//            } catch (SQLException ex) {
//                System.err.println("Erreur lors de l'update : " + ex.getMessage());
//            }
//        }
//
//    public Collection<Nouvelle> listLastN(int n) {
//        ArrayList<Nouvelle> list = new ArrayList<>();
//            String sql = "SELECT * FROM " + table + " ORDER BY created DESC LIMIT ?";
//            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
//                pstmt.setInt(1, n);
//                ResultSet rs = pstmt.executeQuery();
//                while (rs.next()) {
//                    Nouvelle obj = createObject(rs);
//                    list.add(obj);
//                }
//            } catch (SQLException ex) {
//                System.err.println("Erreur lors du listage : " + ex.getMessage());
//            }
//            return list;
//
//        }
//    }
