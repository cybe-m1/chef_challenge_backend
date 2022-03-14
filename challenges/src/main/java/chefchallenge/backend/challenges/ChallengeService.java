package chefchallenge.backend.challenges;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeService {
    private final ChallengeRepository challengeRepository;

    public ChallengeService(ChallengeRepository challengeRepository) {
        this.challengeRepository = challengeRepository;
    }

    public List<Challenge> getAllChallenge() {
        return challengeRepository.findAll();
    }

    public Challenge getChallenge(int id_challenge) {
        return challengeRepository.getById(id_challenge);
    }

    public List<Challenge> getChallengeByName(String name_challenge) {
        return challengeRepository.findByNameContaining(name_challenge);
    }

    public Challenge addChallenge(Challenge challenge) {
        if (challengeRepository.existsById(challenge.getId_challenge())) {
            throw new IllegalArgumentException("Id: " + challenge.getId_challenge() + " already used");
        } else {
            return challengeRepository.save(challenge);
        }
    }

    public Challenge modifyChallenge(Challenge challenge) {
        if (challengeRepository.existsById(challenge.getId_challenge())) {
            return challengeRepository.save(challenge);
        } else {
            throw new IllegalArgumentException("Id: " + challenge.getId_challenge() + " not found");
        }
    }

    public String deleteChallenge(int id_challenge) {
        if (challengeRepository.existsById(id_challenge)) {
            Challenge challengeToDelete = challengeRepository.getById(id_challenge);
            challengeRepository.delete(challengeToDelete);
            return "User deleted";
        } else {
            return "Id: " + id_challenge + " dosen't exist";
        }
    }
}
