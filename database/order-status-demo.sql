-- Replace 1 with the OrderId created from the COD checkout page, then run one UPDATE at a time.
USE VideoHub24162049;
GO
DECLARE @OrderId BIGINT=1;
-- New order
UPDATE Orders SET Status='NEW',UpdatedAt=SYSDATETIME() WHERE OrderId=@OrderId;
-- Confirmed
-- UPDATE Orders SET Status='CONFIRMED',UpdatedAt=SYSDATETIME() WHERE OrderId=@OrderId;
-- Preparing goods
-- UPDATE Orders SET Status='PREPARING',UpdatedAt=SYSDATETIME() WHERE OrderId=@OrderId;
-- In transit
-- UPDATE Orders SET Status='SHIPPING',UpdatedAt=SYSDATETIME() WHERE OrderId=@OrderId;
-- Out for delivery
-- UPDATE Orders SET Status='DELIVERING',UpdatedAt=SYSDATETIME() WHERE OrderId=@OrderId;
-- Delivered
-- UPDATE Orders SET Status='DELIVERED',UpdatedAt=SYSDATETIME() WHERE OrderId=@OrderId;
-- Cancelled
-- UPDATE Orders SET Status='CANCELLED',UpdatedAt=SYSDATETIME() WHERE OrderId=@OrderId;
-- Returned
-- UPDATE Orders SET Status='RETURNED',UpdatedAt=SYSDATETIME() WHERE OrderId=@OrderId;
SELECT OrderId,Username,Status,UpdatedAt FROM Orders WHERE OrderId=@OrderId;
