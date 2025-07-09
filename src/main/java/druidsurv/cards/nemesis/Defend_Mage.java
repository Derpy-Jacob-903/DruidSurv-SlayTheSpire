package druidsurv.cards.nemesis;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.CharacterFile;
import druidsurv.NemCharacterFile;
import druidsurv.cards.AbstractPowerCostCard;

import static druidsurv.ModFile.makeID;

public class Defend_Mage extends AbstractPowerCostCard {
    public final static String ID = makeID("NemDefend");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public Defend_Mage() {
        super(ID, 1, CardType.SKILL, CardRarity.BASIC, CardTarget.SELF, CharacterFile.Enums.NEMDRUID_COLOR, "Defend");
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