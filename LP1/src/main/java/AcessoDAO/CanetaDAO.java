package AcessoDAO;

import ConnectionFA.ConnectionFactory;
import sample.lp1.Caneta;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CanetaDAO {

    public void canetanova (Caneta caneta) throws Exception{
        String sql = "INSERT INTO caneta (cor_caneta, marca_caneta, ponta) VALUES (?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        conn = ConnectionFactory.createConnectionToMySQL();
        pstm = (PreparedStatement) conn.prepareStatement(sql);

        pstm.setString(1, caneta.getCor());
        pstm.setString(2, caneta.getMarca());
        pstm.setString(3, caneta.getPonta());


        pstm.execute();

        if (pstm!=null){
            pstm.close();
        }

        if (conn != null){
            conn.close();
        }
    }

}
