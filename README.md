# Huy Video 24162049

Ứng dụng Java Web dùng Servlet, JSP/JSTL, JDBC, SQL Server, SiteMesh và Tomcat 9.

## Chức năng thương mại

- Giỏ hàng lưu trong session: thêm, cập nhật, xóa; số lượng từ 1 đến tồn kho và tối đa 20 mỗi sản phẩm.
- Thanh toán COD: kiểm tra thông tin nhận hàng, tạo đơn trong transaction, lưu giá tại thời điểm mua và trừ tồn kho an toàn.
- Lịch sử đơn của người đăng nhập, xem chi tiết và lọc theo 8 trạng thái: `NEW`, `CONFIRMED`, `PREPARING`, `SHIPPING`, `DELIVERING`, `DELIVERED`, `CANCELLED`, `RETURNED`.
- Tất cả thao tác thay đổi dữ liệu dùng POST và CSRF token.

## Cài đặt

1. Cài JDK 17, Maven, Apache Tomcat 9 và SQL Server.
2. Database mới: chạy `database/schema.sql`, sau đó `database/seed.sql`.
3. Database `VideoHub24162049` đã tồn tại: chạy `database/migration_cart_orders.sql` đúng một lần.
4. Sao chép `config/application.properties.example` thành `config/local.properties` và điền cấu hình máy cục bộ.
5. Thêm VM argument cho Tomcat:

   ```text
   -DAPP_CONFIG="D:\duong-dan-du-an\config\local.properties"
   ```

6. Import bằng **Existing Maven Projects**, chạy **Maven > Update Project**, thêm project vào Tomcat 9 và mở:

   ```text
   http://localhost:8080/video-24162049/home
   ```

Tài khoản mẫu: `admin / Demo@123` hoặc `user01 / Demo@123`.

## Quan sát trạng thái đơn hàng

Sau khi tạo đơn COD, lấy `OrderId` ở trang chi tiết. Mở `database/order-status-demo.sql`, thay biến `@OrderId`, bỏ chú thích đúng một câu `UPDATE`, rồi chạy trong SSMS. Tải lại `/orders` và chọn trạng thái tương ứng.

Ví dụ:

```sql
UPDATE Orders
SET Status='SHIPPING', UpdatedAt=SYSDATETIME()
WHERE OrderId=1;
```

## Kiểm thử

```text
mvn test
```

Bộ kiểm thử gồm 21 kiểm tra cho xác thực, phân quyền, CRUD, OTP, giỏ hàng, giới hạn tồn kho, COD, trừ tồn kho và lọc trạng thái đơn.
