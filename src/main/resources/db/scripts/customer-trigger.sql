CREATE OR REPLACE FUNCTION create_alias_id() RETURNS trigger AS $alias_id$

BEGIN
    -- Check that gpf alias id is null
    IF NEW.alias_id IS NULL THEN
        NEW.alias_id := 'C' || TO_CHAR(NEW.id, 'fm000000000');
    END IF;
    RETURN NEW;
END;

$alias_id$ LANGUAGE plpgsql;;

DROP TRIGGER IF EXISTS create_alias_id_trigger on customer;;
CREATE TRIGGER create_alias_id_trigger BEFORE INSERT OR UPDATE ON customer FOR EACH ROW EXECUTE PROCEDURE create_alias_id() ;;