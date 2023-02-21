/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dto.HoaDonDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.HoaDonService;
import service.KhachHangService;
import service.NhanVienService;
import service.impl.HoaDonServiceImpl;
import service.impl.KhachHangServiceImpl;
import service.impl.NhanVienServiceImpl;

/**
 *
 * @author macbook
 */
public class ViewHoaDon extends javax.swing.JFrame {

    private final HoaDonService hoaDonService;
    private final KhachHangService khachHangService;
    private final NhanVienService nhanVienService;
    private int currentPage;
    private int totalPages;
    private final int pageSize;
    private long totalHoaDon;

    /**
     * Creates new form ViewHoaDon
     */
    public ViewHoaDon() {
        initComponents();

        jdNgayNhan.setDate(new Date());
        jdNgayShip.setDate(new Date());
        jdNgayTao.setDate(new Date());
        jdNgayThanhToan.setDate(new Date());

        hoaDonService = new HoaDonServiceImpl();
        khachHangService = new KhachHangServiceImpl();
        nhanVienService = new NhanVienServiceImpl();
        currentPage = 1;
        pageSize = 10;

        loadDataTable();
        loadDataKH();
        loadDataNV();
    }

    private void loadDataKH() {
        Object[] listKH = khachHangService.findAll().stream().map(khachHangDTO -> khachHangDTO.getMa()).toArray();
        cbKH.setModel(new DefaultComboBoxModel(listKH));

    }

    private void loadDataNV() {
        Object[] listNV = nhanVienService.findAll().stream().map(nhanVienDTO -> nhanVienDTO.getMa()).toArray();
        cbNV.setModel(new DefaultComboBoxModel(listNV));
    }

    private void loadDataTable() {
        DefaultTableModel dtm = (DefaultTableModel) tbHoaDon.getModel();
        tbHoaDon.setModel(dtm);
        dtm.setRowCount(0);
        List<HoaDonDTO> listDTO = hoaDonService.findAll(currentPage - 1, pageSize);
        for (HoaDonDTO hoaDonDTO : listDTO) {
            dtm.addRow(new Object[]{
                hoaDonDTO.getId(),
                Objects.nonNull(hoaDonDTO.getKhachHang()) ? hoaDonDTO.getKhachHang().getMa() : "",
                Objects.nonNull(hoaDonDTO.getNhanVien()) ? hoaDonDTO.getNhanVien().getMa() : "",
                hoaDonDTO.getMa(),
                hoaDonDTO.getNgayTao(),
                hoaDonDTO.getNgayThanhToan(),
                hoaDonDTO.getNgayShip(),
                hoaDonDTO.getNgayNhan(),
                hoaDonDTO.getTinhTrang(),
                hoaDonDTO.getTenNguoiNhan(),
                hoaDonDTO.getDiaChi(),
                hoaDonDTO.getSdt()
            });
        }
        totalHoaDon = hoaDonService.totalCount();
        totalPages = (int) (totalHoaDon / pageSize) + 1;
        setStatePagination();
    }

    private void setStatePagination() {
        lbTotal.setText("Total: " + totalHoaDon);
        btnNext.setEnabled(currentPage < totalPages);
        btnPrevious.setEnabled(currentPage > 1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        cbKH = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbNV = new javax.swing.JComboBox<>();
        btnNew = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        cbTinhTrang = new javax.swing.JComboBox<>();
        btnDelete = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jdNgayNhan = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHoaDon = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtNguoiNhan = new javax.swing.JTextField();
        btnPrevious = new javax.swing.JButton();
        txtSDT = new javax.swing.JTextField();
        btnNext = new javax.swing.JButton();
        lbPagination = new javax.swing.JLabel();
        jdNgayTao = new com.toedter.calendar.JDateChooser();
        jdNgayThanhToan = new com.toedter.calendar.JDateChooser();
        jdNgayShip = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel10.setText("SDT");

        lbTotal.setText("Total: 0");

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel1.setText("Danh sách Hoá đơn");

        jLabel13.setText("Nhân viên");

        jLabel2.setText("Mã");

        jLabel14.setText("Tình trạng");

        cbKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKHActionPerformed(evt);
            }
        });

        jLabel3.setText("Ngày ship");

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

        cbTinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1" }));

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel4.setText("Ngày thanh toán");

        jdNgayNhan.setDateFormatString("yyyy-MM-dd");

        jLabel5.setText("Ngày tạo");

        jLabel6.setText("Ngày nhận");

        jLabel7.setText("Khách hàng");

        jLabel8.setText("Địa chỉ");

        tbHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "KH", "NV", "Mã", "Ngày tạo", "Ngày thanh toán", "Ngày ship", "Ngày nhận", "Tình trạng", "Tên người nhận", "Địa chỉ", "SDT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, true, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbHoaDon);

        jLabel9.setText("Tên người nhận");

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

        lbPagination.setText("1/1");

        jdNgayTao.setDateFormatString("yyyy-MM-dd");

        jdNgayThanhToan.setDateFormatString("yyyy-MM-dd");

        jdNgayShip.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(53, 53, 53))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbNV, javax.swing.GroupLayout.Alignment.TRAILING, 0, 130, Short.MAX_VALUE)
                                .addComponent(cbKH, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMa, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jdNgayThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jdNgayNhan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jdNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jdNgayShip, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                            .addComponent(txtNguoiNhan, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSDT))
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPrevious)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext)
                        .addGap(18, 18, 18)
                        .addComponent(lbPagination)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbTotal)
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(btnNew)
                        .addGap(106, 106, 106)
                        .addComponent(btnUpdate)
                        .addGap(128, 128, 128)
                        .addComponent(btnDelete)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel7)
                                            .addComponent(cbKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNguoiNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(jdNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8))
                                    .addComponent(jdNgayThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10))
                                    .addComponent(jdNgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jdNgayShip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13)
                                    .addComponent(cbNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(cbTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel5))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrevious)
                    .addComponent(btnNext)
                    .addComponent(lbPagination)
                    .addComponent(lbTotal))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private HoaDonDTO getHoaDonFromInput() {
        String maKH = cbKH.getSelectedItem().toString();
        String maNV = cbNV.getSelectedItem().toString();
        String ma = txtMa.getText();
        Date ngayTao = jdNgayTao.getDate();
        Date ngayThanhToan = jdNgayThanhToan.getDate();
        Date ngayShip = jdNgayShip.getDate();
        Date ngayNhan = jdNgayNhan.getDate();
        int tinhTrang = Integer.parseInt(cbTinhTrang.getSelectedItem().toString());
        String tenNguoiNhan = txtNguoiNhan.getText();
        String diaChi = txtDiaChi.getText();
        String SDT = txtSDT.getText();

        HoaDonDTO hoaDonDTO = new HoaDonDTO();
        hoaDonDTO.setMa(ma);
        hoaDonDTO.setKhachHang(khachHangService.findByMa(maKH));
        hoaDonDTO.setNhanVien(nhanVienService.findByMa(maNV));
        hoaDonDTO.setNgayTao(ngayTao);
        hoaDonDTO.setNgayNhan(ngayNhan);
        hoaDonDTO.setNgayShip(ngayShip);
        hoaDonDTO.setNgayThanhToan(ngayThanhToan);
        hoaDonDTO.setTinhTrang(tinhTrang);
        hoaDonDTO.setTenNguoiNhan(tenNguoiNhan);
        hoaDonDTO.setDiaChi(diaChi);
        hoaDonDTO.setSdt(SDT);
        return hoaDonDTO;
    }

    private String getSelectedIdFromTable() {
        int selectedRow = tbHoaDon.getSelectedRow();
        if (selectedRow < 0) {
            return null;
        }
        String selectedId = tbHoaDon.getValueAt(selectedRow, 0).toString();
        return selectedId;
    }

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        HoaDonDTO hoaDonDTO = getHoaDonFromInput();
        String result = hoaDonService.create(hoaDonDTO);
        JOptionPane.showMessageDialog(this, result);
        loadDataTable();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        HoaDonDTO hoaDonDTO = getHoaDonFromInput();
        String selectedId = getSelectedIdFromTable();
        if (selectedId == null) {
            JOptionPane.showMessageDialog(this, "Chưa chọn hàng");
            return;
        }
        hoaDonDTO.setId(UUID.fromString(selectedId));

        String result = hoaDonService.update(hoaDonDTO);
        JOptionPane.showMessageDialog(this, result);
        loadDataTable();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        UUID selectedId = UUID.fromString(getSelectedIdFromTable());
        if (selectedId == null) {
            JOptionPane.showMessageDialog(this, "Chưa chọn hàng");
            return;
        }
        if (nhanVienService.delete(selectedId)) {
            JOptionPane.showMessageDialog(this, "Xoá thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Xoá thất bại");
        }
        loadDataTable();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tbHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHoaDonMouseClicked
        int row = this.tbHoaDon.getSelectedRow();
        if (row == -1) {
            return;
        }

        String maKH = this.tbHoaDon.getValueAt(row, 1).toString();
        String maNV = this.tbHoaDon.getValueAt(row, 2).toString();
        String ma = this.tbHoaDon.getValueAt(row, 3).toString();
        String ngayTao = this.tbHoaDon.getValueAt(row, 4).toString();
        String ngayThanhToan = this.tbHoaDon.getValueAt(row, 5).toString();
        String ngayShip = this.tbHoaDon.getValueAt(row, 6).toString();
        String ngayNhan = this.tbHoaDon.getValueAt(row, 7).toString();
        String tinhTrang = this.tbHoaDon.getValueAt(row, 8).toString();
        String tenNguoiNhan = this.tbHoaDon.getValueAt(row, 9).toString();
        String diaChi = this.tbHoaDon.getValueAt(row, 10).toString();
        String SDT = this.tbHoaDon.getValueAt(row, 11).toString();

        cbKH.setSelectedItem(maKH);
        cbNV.setSelectedItem(maNV);
        txtMa.setText(ma);
        try {
            jdNgayNhan.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(ngayNhan));
            jdNgayShip.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(ngayShip));
            jdNgayTao.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(ngayTao));
            jdNgayThanhToan.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(ngayThanhToan));
        } catch (ParseException ex) {
            Logger.getLogger(ViewHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        cbTinhTrang.setSelectedItem(tinhTrang);
        txtNguoiNhan.setText(tenNguoiNhan);
        txtDiaChi.setText(diaChi);
        txtSDT.setText(SDT);

    }//GEN-LAST:event_tbHoaDonMouseClicked

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

    private void cbKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbKHActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbKH;
    private javax.swing.JComboBox<String> cbNV;
    private javax.swing.JComboBox<String> cbTinhTrang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdNgayNhan;
    private com.toedter.calendar.JDateChooser jdNgayShip;
    private com.toedter.calendar.JDateChooser jdNgayTao;
    private com.toedter.calendar.JDateChooser jdNgayThanhToan;
    private javax.swing.JLabel lbPagination;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JTable tbHoaDon;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtNguoiNhan;
    private javax.swing.JTextField txtSDT;
    // End of variables declaration//GEN-END:variables
}