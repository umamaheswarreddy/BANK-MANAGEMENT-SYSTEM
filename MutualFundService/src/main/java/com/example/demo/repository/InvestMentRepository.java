package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Investment;

@Repository
public interface InvestMentRepository extends JpaRepository<Investment, Integer> {

//	@Query(value = "SELECT * FROM Investment t where t.pan = :pan AND t.i_Id = :iId", nativeQuery = true)
//	Optional<Investment> findByPanANDIId(@Param("pan") String pan, @Param("iId") int iId);

	Optional<List<Investment>> findAllByPan(String pan);

	@Query(value = "SELECT * FROM Investment t WHERE t.pan=:pan AND t.mutual_fund_id=:MutualFundId", nativeQuery = true)
	List<Investment> findAllByPanANDMutualFundId(@Param("pan") String pan, @Param("MutualFundId") int mutualFundId);

	@Query(value = "select * from Investment  t where t.mutual_fund_id=:MutualFundId", nativeQuery = true)
	List<Investment> findAllByMutualFundId(@Param("MutualFundId") int mutualFundId);

}
