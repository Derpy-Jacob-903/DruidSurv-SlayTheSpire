package druidsurv.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.powers.onedelaybloon;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.atb;

public class WhiteBloon extends AbstractEasyCard {
    public final static String ID = makeID("WhiteBloon");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public WhiteBloon() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseBlock = 5;
        tags.add(druidsurv.cards.cardvars.CardTags.BLOON);
        tags.add(druidsurv.cards.cardvars.CardTags.BASIC);
        setBackgroundTexture("druidsurvResources/images/512/bloon_skill.png", "druidsurvResources/images/1024/bloon_skill.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        blck();
        atb(new DrawCardAction(1));
    }

    @Override
    public void upp()
    {
        upgradeBlock(5);
    }
}