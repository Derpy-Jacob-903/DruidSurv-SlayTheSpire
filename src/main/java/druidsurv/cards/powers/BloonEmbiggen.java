package druidsurv.cards.powers;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.CharacterFile;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.util.CascadeHandler;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.makeInHand;

public class BloonEmbiggen extends AbstractEasyCard {
    public final static String ID = makeID("BloonEmbiggen");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public BloonEmbiggen() {
        super(ID,0, CardType.SKILL, CardRarity.COMMON, CardTarget.ALL_ENEMY, CharacterFile.Enums.STRIKER_COLOR, "BloonEmbiggen_CardArt");
        baseMagicNumber = 3;
        magicNumber = baseMagicNumber;
        exhaust = true;
        this.setCardBack(cardSubType.POWER);
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        /*CascadeHandler s = new CascadeHandler();
        for (int i = 0; i < AbstractDungeon.getCurrRoom().monsters.monsters.size(); i++) {
            AbstractMonster a = AbstractDungeon.getCurrRoom().monsters.monsters.get(i);
            s.embiggen(a, magicNumber);
        }*/
    }

    @Override
    public void upp() {
        upgradeMagicNumber(2);
    }
}