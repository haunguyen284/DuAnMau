/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dto.MauSacDTO;
import java.util.List;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.MauSacService;
import service.impl.MauSacServiceImpl;

/**
 *
 * @author macbook
 */
public class ViewMauSac extends javax.swing.JFrame {
    private MauSacService mauSacService;
    private int currentPage;
    private int pageSize;
    private long totalNSX;
    private int totalPages;

    /**
     * Creates new form ViewMauSac
     */
    public ViewMauSac() {
        initComponents();
        mauSacService = new MauSacServiceImpl();
        currentPage = 1;
        pageSize = 10;
    }
    
    private void loadDataTable() {
        DefaultTableModel dtm = (DefaultTableModel) tbMauSac.getModel();
        tbMauSac.setModel(dtm);
        dtm.setRowCount(0);
        List<MauSacDTO> listDTO = mauSacService.findAll(currentPage - 1, pageSize);
        for (MauSacDTO mauSacDTO : listDTO) {
            dtm.addRow(new Object[] {
                mauSacDTO.getId(),
                mauSacDTO.getMa(),
                mauSacDTO.getTen()
            });
        }
        totalNSX = mauSacService.totalCount();
        totalPages = (int) (totalNSX / pageSize) + 1;
        lbTotal.setText("Total: " + totalPages);
        setStatePagination();
    }
    
    private void setStatePagination() {
        btnNext.setEnabled(currentPage < totalPages);
        btnPrevious.setEnabled(currentPage > 1);
        lbPagination.setText(currentPage + "/" + totalPages);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPrevious = new javax.swing.JButton();
        txtTen = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMauSac = new javax.swing.JTable();
        btnNext = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbPagination = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        btnNew = new javax.swing.JButton();
        lbTotal = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnPrevious.setText("<");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel1.setText("Danh sách Nhà sản xuất");

        tbMauSac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Mã", "Tên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbMauSac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMauSacMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbMauSac);

        btnNext.setText(">");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        jLabel2.setText("Mã");

        lbPagination.setText("1/1");

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        lbTotal.setText("Total: 0");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel3.setText("Tên");

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(97, 97, 97))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnNew)
                            .addGap(78, 78, 78)
                            .addComponent(btnUpdate)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelete))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnPrevious)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnNext)
                            .addGap(18, 18, 18)
                            .addComponent(lbPagination)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbTotal))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrevious)
                    .addComponent(btnNext)
                    .addComponent(lbPagination)
                    .addComponent(lbTotal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private MauSacDTO getMauSacFromInput(){
        MauSacDTO mauSacDTO = new MauSacDTO();
        String ma = txtMa.getText();
        String ten = txtTen.getText();
        
        mauSacDTO.setMa(ma);
        mauSacDTO.setTen(ten);
        return mauSacDTO;
    }
    
    private String getSelectedIdFromTable(){
        int selectedRow = tbMauSac.getSelectedRow();
        if (selectedRow == -1) return null;
        String selectedId = tbMauSac.getValueAt(selectedRow, 0).toString();
        return selectedId;
    }
    
    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        if (currentPage > 1) {
            currentPage--;
        }
        loadDataTable();
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void tbMauSacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMauSacMouseClicked
        int row = this.tbMauSac.getSelectedRow();
        if (row == -1) {
            return;
        }

        String ma = this.tbMauSac.getValueAt(row, 1).toString();
        String ten = this.tbMauSac.getValueAt(row, 2).toString();

        this.txtMa.setText(ma);
        this.txtTen.setText(ten);
    }//GEN-LAST:event_tbMauSacMouseClicked

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        if (currentPage < totalPages) {
            currentPage++;
        }
        loadDataTable();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        MauSacDTO mauSacDTO = getMauSacFromInput();
        String result = mauSacService.create(mauSacDTO);
        JOptionPane.showMessageDialog(this, result);
        loadDataTable();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        MauSacDTO mauSacDTO = getMauSacFromInput();
        String selectedId = getSelectedIdFromTable();
        if (selectedId == null){
            JOptionPane.showMessageDialog(this, "Chưa chọn hàng để thực hiện");
            return;
        }
        mauSacDTO.setId(UUID.fromString(selectedId));

        String result = mauSacService.update(mauSacDTO);
        JOptionPane.showMessageDialog(this, result);
        loadDataTable();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String selectedId = getSelectedIdFromTable();
        if (selectedId == null){
            JOptionPane.showMessageDialog(this, "Chưa chọn hàng để thực hiện");
            return;
        }
        if (mauSacService.delete(UUID.fromString(selectedId))){
            JOptionPane.showMessageDialog(this, "Xoá thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Xoá thất bại");
        }
        loadDataTable();
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbPagination;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JTable tbMauSac;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
