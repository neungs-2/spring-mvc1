package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 동시성 문제가 고려되지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용을 고려
 */
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    // 싱글톤 구현을 위해 instance 사용 (스프링을 안 쓰고 있기 때문)
    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }

    // 싱글톤으로 만들 땐, 아무나 생성하지 못하도록 생성자를 private으로 생성
    private MemberRepository() {}

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public void clearStore() {
        store.clear();
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
