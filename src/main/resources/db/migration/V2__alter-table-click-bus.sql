ALTER TABLE crud_click_bus
DROP COLUMN updatedAt, 
DROP COLUMN createdAt, 
ADD COLUMN created_at DATE, 
ADD COLUMN updated_at DATE;