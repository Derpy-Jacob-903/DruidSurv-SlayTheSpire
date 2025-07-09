package druidsurv.cards.bloons;

import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.PersistFields;
import com.evacipated.cardcrawl.mod.stslib.variables.ExhaustiveVariable;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.orbs.Dark;
import druidsurv.cards.AbstractEasyCard;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.atb;

public class DarkBloon extends AbstractEasyCard {
    public final static String ID = makeID("DarkBloon");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public DarkBloon() {
        super(ID, 1, CardType.ATTACK, CardRarity.SPECIAL, CardTarget.SELF_AND_ENEMY, "NoArt");
        baseDamage = 16;
        baseBlock = 5;
        tags.add(druidsurv.cards.cardvars.CardTags.BLOON);
        tags.add(druidsurv.cards.cardvars.CardTags.ADVANCED);
        //PersistFields.setBaseValue(this, 2);
        //ExhaustiveVariable.setBaseValue(this, 2);
        setPortraitTextures("druidsurvResources/images/cardui/512/frame_skill_void.png", "druidsurvResources/images/cardui/1024/frame_skill_void.png");
        this.setCardBack(cardSubType.BLOON);
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        atb(new ChannelAction(new Dark()));
        bloonBlck();
    }

    @Override
    public void upp() {
        upgradeDamage(8);
    }
}