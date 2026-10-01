-- Create SQL login video_app privately via SSMS first. No real password belongs here.
USE VideoHub24162049;
GO
IF DATABASE_PRINCIPAL_ID(N'video_app') IS NULL
    CREATE USER video_app FOR LOGIN video_app;
GRANT SELECT, INSERT, UPDATE, DELETE ON dbo.Users TO video_app;
GRANT SELECT, INSERT, UPDATE, DELETE ON dbo.Category TO video_app;
GRANT SELECT, INSERT, UPDATE, DELETE ON dbo.Videos TO video_app;
GRANT SELECT, INSERT, UPDATE, DELETE ON dbo.Favorites TO video_app;
GRANT SELECT, INSERT, UPDATE, DELETE ON dbo.Shares TO video_app;
GRANT UPDATE ON OBJECT::dbo.VideoSequence TO video_app;
GO
