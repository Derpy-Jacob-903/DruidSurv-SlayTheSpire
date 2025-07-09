package druidsurv.cards.colorless;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractEasyCard;

import static druidsurv.ModFile.makeID;

public class Defend_Colorless extends AbstractEasyCard {
    public final static String ID = makeID("DefendC");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public Defend_Colorless() {
        super(ID, 1, CardType.SKILL, CardRarity.BASIC, CardTarget.SELF, CardColor.COLORLESS, "Defend");
        baseBlock = 5;
        tags.add(CardTags.STARTER_DEFEND);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        blck();
    }

    @Override
    public void upp() {
        upgradeBlock(3);
    }
}