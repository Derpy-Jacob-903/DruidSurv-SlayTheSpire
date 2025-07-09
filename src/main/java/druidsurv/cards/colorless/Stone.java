package druidsurv.cards.colorless;

import basemod.AutoAdd;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractEasyCard;

import static druidsurv.ModFile.makeID;

@AutoAdd.Ignore
public class Stone extends AbstractEasyCard {
    public final static String ID = makeID("Stone");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public Stone() {
        super(ID, -2, CardType.STATUS, CardRarity.SPECIAL, CardTarget.NONE, "stone");
        baseBlock = 8;
        setPortraitTextures("druidsurvResources/images/1024/blank.png", "druidsurvResources/images/1024/blank.png");
        setBackgroundTexture("druidsurvResources/images/512/stone.png", "druidsurvResources/images/1024/stone.png");
    }

    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
    }

    public void triggerOnEndOfTurnForPlayingCard() {
        blck();
    }

    @Override
    public void upp() {
        upgradeBlock(3);
    }
}