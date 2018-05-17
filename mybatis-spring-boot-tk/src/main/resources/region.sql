CREATE  PROCEDURE `showTreeNodes_regions`(IN rootid INT)
BEGIN
 DECLARE Level int ;
 drop TABLE IF EXISTS tmpLst_regions;
 CREATE TABLE tmpLst_regions (
  id int,
  nLevel int,
  sCort varchar(8000)
 );
 
 Set Level=0 ;
 INSERT into tmpLst_regions SELECT region_id,Level,region_id FROM es_regions WHERE p_region_id=rootid;
 WHILE ROW_COUNT()>0 DO
  SET Level=Level+1 ;
  INSERT into tmpLst_regions 
   SELECT A.region_id,Level,concat(B.sCort,A.region_id) FROM es_regions A,tmpLst_regions B 
    WHERE  A.p_region_id=B.ID AND B.nLevel=Level-1  ;
 END WHILE;
  
END