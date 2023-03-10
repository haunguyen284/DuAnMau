/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dto.KhachHangDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.KhachHangService;
import service.impl.KhachHangServiceImpl;

/**
 *
 * @author macbook
 */
public class ViewKhachHang extends javax.swing.JFrame {
    private final KhachHangService khachHangService;
    private int currentPage;
    private int totalPages;
    private long totalKhachHang;
    private final int pageSize;

    /**
     * Creates new form ViewKhachHang
     */
    public ViewKhachHang() {
        initComponents();
        pageSize = 10;
        currentPage = 1;
        jdNgaySinh.setDate(new Date());
        khachHangService = new KhachHangServiceImpl();
    }
    
    private void loadDataTable() {
        List<KhachHangDTO> listDTO = khachHangService.findAll(currentPage - 1, pageSize);
        DefaultTableModel dtm = (DefaultTableModel) tbKhachHang.getModel();
        tbKhachHang.setModel(dtm);
        dtm.setRowCount(0);
        for (KhachHangDTO khachHangDTO : listDTO) {
            dtm.addRow(new Object[] {
                khachHangDTO.getId(),
                khachHangDTO.getMa(),
                khachHangDTO.getTen(),
                khachHangDTO.getTenDem(),
                khachHangDTO.getHo(),
                khachHangDTO.getNgaySinh(),
                khachHangDTO.getSdt(),
                khachHangDTO.getDiaChi(),
                khachHangDTO.getThanhPho(),
                khachHangDTO.getQuocGia(),
                khachHangDTO.getMatKhau()
            });
        }
        totalKhachHang = khachHangService.totalCount();
        lbTotal.setText("Total: " + totalKhachHang);
        totalPages = (int) (totalKhachHang / pageSize) + 1;
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

        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        btnNew = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jdNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        txtHo = new javax.swing.JTextField();
        txtTenDem = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbKhachHang = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        btnPrevious = new javax.swing.JButton();
        txtMatKhau = new javax.swing.JTextField();
        btnNext = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        lbPagination = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtQuocGia = new javax.swing.JTextField();
        txtThanhPho = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel1.setText("Danh s??ch Kh??ch h??ng");

        jLabel13.setText("Th??nh ph???");

        jLabel2.setText("M??");

        jLabel3.setText("T??n");

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jdNgaySinh.setDateFormatString("yyyy-MM-dd");

        jLabel4.setText("H???");

        jLabel5.setText("T??n ?????m");

        jLabel6.setText("Ng??y sinh");

        jLabel8.setText("?????a ch???");

        tbKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "M??", "T??n", "T??n ?????m", "H???", "Ng??y sinh", "SDT", "?????a ch???", "Th??nh ph???", "Qu???c gia", "M???t kh???u"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbKhachHang);

        jLabel9.setText("SDT");

        btnPrevious.setText("<");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnNext.setText(">");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        jLabel10.setText("M???t kh???u");

        lbPagination.setText("1/1");

        lbTotal.setText("Total: 0");

        jLabel12.setText("Qu???c gia");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPrevious)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext)
                        .addGap(18, 18, 18)
                        .addComponent(lbPagination)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbTotal))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtMa, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                    .addComponent(txtTen, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtThanhPho))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(11, 11, 11))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtHo, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtTenDem, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jdNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                            .addComponent(txtQuocGia))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnNew)
                                .addGap(106, 106, 106)
                                .addComponent(btnUpdate)
                                .addGap(128, 128, 128)
                                .addComponent(btnDelete)))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTenDem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(txtThanhPho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13))
                            .addComponent(jdNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtQuocGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrevious)
                    .addComponent(btnNext)
                    .addComponent(lbPagination)
                    .addComponent(lbTotal))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private KhachHangDTO getKhachHangFromInput() {
        String ma = txtMa.getText();
        String ten = txtTen.getText();
        String tenDem = txtTenDem.getText();
        String ho = txtHo.getText();
        Date ngaySinh = jdNgaySinh.getDate();
        String SDT = txtSDT.getText();
        String diaChi = txtDiaChi.getText();
        String thanhPho = txtThanhPho.getText();
        String quocGia = txtQuocGia.getText();
        String matKhau = txtMatKhau.getText();
        
        KhachHangDTO khachHangDTO = new KhachHangDTO();
        khachHangDTO.setMa(ma);
        khachHangDTO.setTen(ten);
        khachHangDTO.setTenDem(tenDem);
        khachHangDTO.setHo(ho);
        khachHangDTO.setNgaySinh(ngaySinh);
        khachHangDTO.setSdt(SDT);
        khachHangDTO.setDiaChi(diaChi);
        khachHangDTO.setThanhPho(thanhPho);
        khachHangDTO.setQuocGia(quocGia);
        khachHangDTO.setMatKhau(matKhau);
        return khachHangDTO;
    }
    
    private String getSelectedIdFromTable() {
        int selectedRow = tbKhachHang.getSelectedRow();
        if (selectedRow < 0) return null;
        String selectedId = tbKhachHang.getValueAt(selectedRow, 0).toString();
        return selectedId;
    }
    
    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        KhachHangDTO khachHangDTO = getKhachHangFromInput();
        String result = khachHangService.create(khachHangDTO);
        JOptionPane.showMessageDialog(this, result);
        loadDataTable();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        KhachHangDTO khachHangDTO = getKhachHangFromInput();
        String selectedId = getSelectedIdFromTable();
        if (selectedId == null) {
            JOptionPane.showMessageDialog(this, "Ch??a ch???n h??ng");
            return;
        }
        khachHangDTO.setId(UUID.fromString(selectedId));

        String result = khachHangService.update(khachHangDTO);
        JOptionPane.showMessageDialog(this, result);
        loadDataTable();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        UUID selectedId = UUID.fromString(getSelectedIdFromTable());
        if (selectedId == null) {
            JOptionPane.showMessageDialog(this, "Ch??a ch???n h??ng");
            return;
        }
        if (khachHangService.delete(selectedId)) {
            JOptionPane.showMessageDialog(this, "Xo?? th??nh c??ng");
        } else {
            JOptionPane.showMessageDialog(this, "Xo?? th???t b???i");
        }
        loadDataTable();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tbKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhachHangMouseClicked
        int row = this.tbKhachHang.getSelectedRow();
        if (row == -1) {
            return;
        }

        String ma = this.tbKhachHang.getValueAt(row, 1).toString();
        String ten = this.tbKhachHang.getValueAt(row, 2).toString();
        String tenDem = this.tbKhachHang.getValueAt(row, 3).toString();
        String ho = this.tbKhachHang.getValueAt(row, 4).toString();
        String ngaySinh = this.tbKhachHang.getValueAt(row, 5).toString();
        String SDT = this.tbKhachHang.getValueAt(row, 6).toString();
        String diaChi = this.tbKhachHang.getValueAt(row, 7).toString();
        String quocGia = this.tbKhachHang.getValueAt(row, 9).toString();
        String thanhPho = this.tbKhachHang.getValueAt(row, 8).toString();
        String matKhau = this.tbKhachHang.getValueAt(row, 10).toString();

        txtMa.setText(ma);
        txtTen.setText(ten);
        txtTenDem.setText(tenDem);
        txtHo.setText(ho);
        try {
            jdNgaySinh.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(ngaySinh));
        } catch (ParseException ex) {
            System.out.println("Ngay sinh loi: " + ex.getMessage());
        }
        txtDiaChi.setText(diaChi);
        txtSDT.setText(SDT);
        txtMatKhau.setText(matKhau);
        txtThanhPho.setText(thanhPho);
        txtQuocGia.setText(quocGia);
    }//GEN-LAST:event_tbKhachHangMouseClicked

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        if (currentPage > 1) {
            currentPage--;
        }
        loadDataTable();
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        if (currentPage < totalPages) {
            currentPage++;
        }
        loadDataTable();
    }//GEN-LAST:event_btnNextActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdNgaySinh;
    private javax.swing.JLabel lbPagination;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JTable tbKhachHang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHo;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtQuocGia;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTenDem;
    private javax.swing.JTextField txtThanhPho;
    // End of variables declaration//GEN-END:variables
}
