package repository;

import model.Lokation;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.awt.*;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class LokationRepositoryTest {

    @Mock
    LokationRepository lokationRepository = new LokationRepository() {

        @BeforeClass
        void before(){
            Point koor1 = new Point(3,6);
            Point koor2 = new Point(78,24);
            Point koor3 = new Point(34,71);
            Point koor4 = new Point(572,679);

            Lokation lok1 = new Lokation(1,"Bjørnehulen", "Her bor bjørnen", koor1);
            Lokation lok2 = new Lokation(2,"Kirken", "Her er kirken", koor2);
            Lokation lok3 = new Lokation(3,"Slottet", "Her er slottet", koor3);
            Lokation lok4 = new Lokation(4,"Kontoret", "Her er kontoret", koor4);

            ArrayList<Lokation> testTable = new ArrayList<Lokation>();

            testTable.add(lok1);
            testTable.add(lok2);
            testTable.add(lok3);
            testTable.add(lok4);

            Mockito.when(lokationRepository.findById(1));
        }

        @Override
        public <S extends Lokation> S save(S entity) {
            return null;
        }

        @Override
        public <S extends Lokation> Iterable<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public Optional<Lokation> findById(Integer integer) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Integer integer) {
            return false;
        }

        @Override
        public Iterable<Lokation> findAll() {
            return null;
        }

        @Override
        public Iterable<Lokation> findAllById(Iterable<Integer> integers) {
            return null;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Integer integer) {

        }

        @Override
        public void delete(Lokation entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Integer> integers) {

        }

        @Override
        public void deleteAll(Iterable<? extends Lokation> entities) {

        }

        @Override
        public void deleteAll() {

        }
    };

}