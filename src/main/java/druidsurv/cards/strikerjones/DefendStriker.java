package druidsurv.cards.strikerjones;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.CharacterFile;
import druidsurv.cards.AbstractEasyCard;

import static druidsurv.ModFile.makeID;

public class DefendStriker extends AbstractEasyCard {
    public final static String ID = makeID("Defend");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public DefendStriker() {
        super(ID, 1, CardType.SKILL, CardRarity.BASIC, CardTarget.SELF, CharacterFile.Enums.STRIKER_COLOR, "Defend");
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